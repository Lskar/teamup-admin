package com.irum.teamup.service.Impl;


import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.lang.UUID;
import com.alibaba.fastjson2.JSON;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.irum.teamup.convention.exception.ClientException;
import com.irum.teamup.enums.AdminErrorCodeEnum;
import com.irum.teamup.mapper.AdminMapper;
import com.irum.teamup.po.AdminDO;
import com.irum.teamup.dto.AdminLoginDTO;
import com.irum.teamup.dto.AdminRegisterDTO;
import com.irum.teamup.dto.AdminUpdateDTO;
import com.irum.teamup.vo.AdminLoginVO;
import com.irum.teamup.vo.AdminVO;
import com.irum.teamup.service.AdminService;
import lombok.RequiredArgsConstructor;
import org.redisson.api.RBloomFilter;
import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;
import org.springframework.beans.BeanUtils;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

import static com.irum.teamup.constant.RedisCacheConstant.LOCK_USER_REGISTER_KEY;
import static com.irum.teamup.enums.AdminErrorCodeEnum.USER_NAME_EXIST;

/**
 * @author irum
 * @date 2022/5/17
 **/
@Service
@RequiredArgsConstructor
public class AdminServiceImpl extends ServiceImpl<AdminMapper, AdminDO> implements AdminService {

    private final RBloomFilter<String> userRegisterCachePenetrationBloomFilter;

    private final RedissonClient redissonClient;

    private final StringRedisTemplate stringRedisTemplate;

    @Override
    public AdminVO getUserByUsername(String username) {
         LambdaQueryWrapper<AdminDO> queryWrapper= Wrappers.lambdaQuery(AdminDO.class)
                .eq(AdminDO::getUsername, username);
        AdminDO adminDO = baseMapper.selectOne(queryWrapper);
        if(adminDO ==null){
            throw new ClientException(AdminErrorCodeEnum.USER_NULL);
        }
        AdminVO result = new AdminVO();
        BeanUtils.copyProperties(adminDO, result);
        return result;
    }

    @Override
    public Boolean hasUsername(String username) {
        return !userRegisterCachePenetrationBloomFilter.contains(username);
    }

    @Override
    public void Register(AdminRegisterDTO requestParam) {
        if(!hasUsername(requestParam.getUsername())){
            throw new ClientException(USER_NAME_EXIST);
        }
        RLock lock = redissonClient.getLock(LOCK_USER_REGISTER_KEY+requestParam.getUsername());
        try {
            if(lock.tryLock()){
                int inserted = baseMapper.insert(BeanUtil.toBean(requestParam, AdminDO.class));
                if(inserted<=0){
                    throw new ClientException(AdminErrorCodeEnum.USER_SAVE_ERROR);
                }
                userRegisterCachePenetrationBloomFilter.add(requestParam.getUsername());
                return;
            }
            throw new ClientException(USER_NAME_EXIST);
        }finally {
            lock.unlock();
        }

    }

    @Override
    public void update(AdminUpdateDTO requestParam) {
        // TODO 验证当前用户为登录用户
        LambdaQueryWrapper<AdminDO> queryWrapper= Wrappers.lambdaQuery(AdminDO.class)
                .eq(AdminDO::getUsername, requestParam.getUsername());
        baseMapper.update(BeanUtil.toBean(requestParam, AdminDO.class), queryWrapper);
    }

    @Override
    public AdminLoginVO login(AdminLoginDTO requestParam) {
        LambdaQueryWrapper<AdminDO> queryWrapper= Wrappers.lambdaQuery(AdminDO.class)
                .eq(AdminDO::getUsername, requestParam.getUsername())
                .eq(AdminDO::getPassword, requestParam.getPassword())
                .eq(AdminDO::getDelFlag, 0);
        AdminDO adminDO = baseMapper.selectOne(queryWrapper);
        if(adminDO ==null){
            throw new ClientException(AdminErrorCodeEnum.USER_NULL);
        }
        Boolean isLogin = stringRedisTemplate.hasKey("login_"+requestParam.getUsername());
        if(isLogin){
            throw new ClientException("用户已登录");
        }

        String uuid = UUID.randomUUID().toString();
        stringRedisTemplate.opsForHash().put("login_"+requestParam.getUsername(),uuid,JSON.toJSONString(adminDO));
        stringRedisTemplate.expire("login_"+requestParam.getUsername(), 30L, TimeUnit.MINUTES);
        return new AdminLoginVO(uuid);
    }

    @Override
    public Boolean checklogin(String username,String token) {
        return stringRedisTemplate.opsForHash().get("login_"+username, token)!=null;
    }
}
