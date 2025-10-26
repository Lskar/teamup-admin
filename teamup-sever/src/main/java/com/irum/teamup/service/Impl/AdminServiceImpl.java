package com.irum.teamup.service.Impl;


import cn.hutool.core.bean.BeanUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.irum.teamup.config.JwtProperties;
import com.irum.teamup.convention.exception.ClientException;
import com.irum.teamup.dto.admin.AdminLoginDTO;
import com.irum.teamup.dto.admin.AdminRegisterDTO;
import com.irum.teamup.dto.admin.AdminUpdateDTO;
import com.irum.teamup.enums.AdminErrorCodeEnum;
import com.irum.teamup.mapper.AdminMapper;
import com.irum.teamup.po.AdminDO;
import com.irum.teamup.service.AdminService;
import com.irum.teamup.utils.JwtTool;
import com.irum.teamup.vo.admin.AdminLoginVO;
import com.irum.teamup.vo.admin.AdminVO;
import lombok.extern.slf4j.Slf4j;
import org.redisson.api.RedissonClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

/**
 * @author irum
 * @date 2022/5/17
 **/
@Service
@Slf4j
public class AdminServiceImpl extends ServiceImpl<AdminMapper, AdminDO> implements AdminService {

//    private final RBloomFilter<String> userRegisterCachePenetrationBloomFilter;

    @Autowired
    private RedissonClient redissonClient;

    @Autowired
    private  StringRedisTemplate stringRedisTemplate;

    @Autowired
    private  JwtTool jwtTool;

    @Autowired
    private  JwtProperties jwtProperties;


    @Override
    public AdminVO getUserByUsername(String username) {
//         LambdaQueryWrapper<AdminDO> queryWrapper= Wrappers.lambdaQuery(AdminDO.class)
//                .eq(AdminDO::getUsername, username);
//        AdminDO adminDO = baseMapper.selectOne(queryWrapper);
//        if(adminDO ==null){
//            throw new ClientException(AdminErrorCodeEnum.USER_NULL);
//        }
//        AdminVO result = new AdminVO();
//        BeanUtils.copyProperties(adminDO, result);
//        return result;
        return null;
    }

    @Override
    public Boolean hasUsername(String username) {
//        return !userRegisterCachePenetrationBloomFilter.contains(username);
        return null;
    }

    @Override
    public void Register(AdminRegisterDTO requestParam) {
//        if(!hasUsername(requestParam.getUsername())){
//            throw new ClientException(USER_NAME_EXIST);
//        }
//        RLock lock = redissonClient.getLock(LOCK_USER_REGISTER_KEY+requestParam.getUsername());
//        try {
//            if(lock.tryLock()){
//                int inserted = baseMapper.insert(BeanUtil.toBean(requestParam, AdminDO.class));
//                if(inserted<=0){
//                    throw new ClientException(AdminErrorCodeEnum.USER_SAVE_ERROR);
//                }
//                userRegisterCachePenetrationBloomFilter.add(requestParam.getUsername());
//                return;
//            }
//            throw new ClientException(USER_NAME_EXIST);
//        }finally {
//            lock.unlock();
//        }

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
//        LambdaQueryWrapper<AdminDO> queryWrapper= Wrappers.lambdaQuery(AdminDO.class)
//                .eq(AdminDO::getUsername, requestParam.getUsername())
//                .eq(AdminDO::getPassword, requestParam.getPassword())
//                .eq(AdminDO::getDelFlag, 0);
//        AdminDO adminDO = baseMapper.selectOne(queryWrapper);
//        if(adminDO ==null){
//            throw new ClientException(AdminErrorCodeEnum.USER_NULL);
//        }
//        Boolean isLogin = stringRedisTemplate.hasKey("login_"+requestParam.getUsername());
//        if(isLogin){
//            throw new ClientException("用户已登录");
//        }
//
//        String uuid = UUID.randomUUID().toString();
//        stringRedisTemplate.opsForHash().put("login_"+requestParam.getUsername(),uuid,JSON.toJSONString(adminDO));
//        stringRedisTemplate.expire("login_"+requestParam.getUsername(), 30L, TimeUnit.MINUTES);
//        return new AdminLoginVO(uuid);

        String username = requestParam.getUsername();
        String password = requestParam.getPassword();


        AdminDO adminDO = lambdaQuery().eq(AdminDO::getUsername, username).one();

        log.debug("adminDO:{}", adminDO);

        if(!adminDO.getPassword().equals(password)){
            throw new ClientException(AdminErrorCodeEnum.USER_SAVE_ERROR);
        }

        String token = jwtTool.createToken(adminDO.getId(), jwtProperties.getTokenTTL());



        AdminLoginVO adminLoginVO = new AdminLoginVO();
        adminLoginVO.setToken(token);
        adminLoginVO.setUsername(adminDO.getUsername());
        adminLoginVO.setUserId(adminDO.getId());

        return adminLoginVO;
    }

    @Override
    public Boolean checklogin(String username,String token) {
//        return stringRedisTemplate.opsForHash().get("login_"+username, token)!=null;
        return null;
    }
}
