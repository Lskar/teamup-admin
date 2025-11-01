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
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * @author irum
 * @date 2022/5/17
 **/
@Service
@Slf4j
@AllArgsConstructor
public class AdminServiceImpl extends ServiceImpl<AdminMapper, AdminDO> implements AdminService {


    private final JwtTool jwtTool;


    private final JwtProperties jwtProperties;


    @Override
    public void Register(AdminRegisterDTO requestParam) {


        int insert = baseMapper.insert(BeanUtil.toBean(requestParam, AdminDO.class));


    }

    @Override
    public void updateByUsername(AdminUpdateDTO requestParam) {

        LambdaQueryWrapper<AdminDO> queryWrapper = Wrappers.lambdaQuery(AdminDO.class)
                .eq(AdminDO::getUsername, requestParam.getUsername());
        baseMapper.update(BeanUtil.toBean(requestParam, AdminDO.class), queryWrapper);
    }

    @Override
    public AdminLoginVO login(AdminLoginDTO requestParam) {

        String username = requestParam.getUsername();
        String password = requestParam.getPassword();


        AdminDO adminDO = lambdaQuery().eq(AdminDO::getUsername, username).one();

        log.debug("adminDO:{}", adminDO);

        if (!adminDO.getPassword().equals(password)) {
            throw new ClientException(AdminErrorCodeEnum.USER_SAVE_ERROR);
        }

        String token = jwtTool.createToken(adminDO.getId(), jwtProperties.getTokenTTL());

        AdminLoginVO adminLoginVO = new AdminLoginVO();
        adminLoginVO.setToken(token);
        adminLoginVO.setUsername(adminDO.getUsername());
        adminLoginVO.setUserId(adminDO.getId());

        return adminLoginVO;
    }


}
