package com.irum.teamup.service.Impl;


import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.lang.UUID;
import com.alibaba.fastjson2.JSON;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.irum.teamup.convention.exception.ClientException;
import com.irum.teamup.enums.UserErrorCodeEnum;
import com.irum.teamup.mapper.UserMapper;
import com.irum.teamup.po.UserDO;
import com.irum.teamup.dto.UserLoginDTO;
import com.irum.teamup.dto.UserRegisterDTO;
import com.irum.teamup.dto.UserUpdateDTO;
import com.irum.teamup.vo.UserLoginVO;
import com.irum.teamup.vo.UserVO;
import com.irum.teamup.service.UserService;
import lombok.RequiredArgsConstructor;
import org.redisson.api.RBloomFilter;
import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;
import org.springframework.beans.BeanUtils;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

import static com.irum.teamup.constant.RedisCacheConstant.LOCK_USER_REGISTER_KEY;
import static com.irum.teamup.enums.UserErrorCodeEnum.USER_NAME_EXIST;

/**
 * @author irum
 * @date 2022/5/17
 **/
@Service
@RequiredArgsConstructor
public class UserServiceImpl extends ServiceImpl<UserMapper, UserDO> implements UserService {

    private final RBloomFilter<String> userRegisterCachePenetrationBloomFilter;

    private final RedissonClient redissonClient;

    private final StringRedisTemplate stringRedisTemplate;

    @Override
    public UserVO getUserByUsername(String username) {
         LambdaQueryWrapper<UserDO> queryWrapper= Wrappers.lambdaQuery(UserDO.class)
                .eq(UserDO::getUsername, username);
        UserDO userDO = baseMapper.selectOne(queryWrapper);
        if(userDO==null){
            throw new ClientException(UserErrorCodeEnum.USER_NULL);
        }
        UserVO result = new UserVO();
        BeanUtils.copyProperties(userDO, result);
        return result;
    }

    @Override
    public Boolean hasUsername(String username) {
        return !userRegisterCachePenetrationBloomFilter.contains(username);
    }

    @Override
    public void Register(UserRegisterDTO requestParam) {
        if(!hasUsername(requestParam.getUsername())){
            throw new ClientException(USER_NAME_EXIST);
        }
        RLock lock = redissonClient.getLock(LOCK_USER_REGISTER_KEY+requestParam.getUsername());
        try {
            if(lock.tryLock()){
                int inserted = baseMapper.insert(BeanUtil.toBean(requestParam, UserDO.class));
                if(inserted<=0){
                    throw new ClientException(UserErrorCodeEnum.USER_SAVE_ERROR);
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
    public void update(UserUpdateDTO requestParam) {
        // TODO 验证当前用户为登录用户
        LambdaQueryWrapper<UserDO> queryWrapper= Wrappers.lambdaQuery(UserDO.class)
                .eq(UserDO::getUsername, requestParam.getUsername());
        baseMapper.update(BeanUtil.toBean(requestParam, UserDO.class), queryWrapper);
    }

    @Override
    public UserLoginVO login(UserLoginDTO requestParam) {
        LambdaQueryWrapper<UserDO> queryWrapper= Wrappers.lambdaQuery(UserDO.class)
                .eq(UserDO::getUsername, requestParam.getUsername())
                .eq(UserDO::getPassword, requestParam.getPassword())
                .eq(UserDO::getDelFlag, 0);
        UserDO userDO = baseMapper.selectOne(queryWrapper);
        if(userDO==null){
            throw new ClientException(UserErrorCodeEnum.USER_NULL);
        }
        Boolean isLogin = stringRedisTemplate.hasKey("login_"+requestParam.getUsername());
        if(isLogin){
            throw new ClientException("用户已登录");
        }

        String uuid = UUID.randomUUID().toString();
        stringRedisTemplate.opsForHash().put("login_"+requestParam.getUsername(),uuid,JSON.toJSONString(userDO));
        stringRedisTemplate.expire("login_"+requestParam.getUsername(), 30L, TimeUnit.MINUTES);
        return new UserLoginVO(uuid);
    }

    @Override
    public Boolean checklogin(String username,String token) {
        return stringRedisTemplate.opsForHash().get("login_"+username, token)!=null;
    }
}
