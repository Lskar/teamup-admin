package com.irum.teamup.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.irum.teamup.po.AdminDO;
import com.irum.teamup.dto.admin.AdminLoginDTO;
import com.irum.teamup.dto.admin.AdminRegisterDTO;
import com.irum.teamup.dto.admin.AdminUpdateDTO;
import com.irum.teamup.vo.admin.AdminLoginVO;
import com.irum.teamup.vo.admin.AdminVO;

/**
 * @author irum
 * @date 2021/09/05
 */
public interface AdminService extends IService<AdminDO> {


    /**
     * 注册用户
     *
     * @param requestParam 注册信息
     */
    void Register(AdminRegisterDTO requestParam);

    /**
     * 更新用户信息
     *
     * @param requestParam 更新信息
     */
    void updateByUsername(AdminUpdateDTO requestParam);

    /**
     * 登录
     *
     * @param requestParam 登录信息
     * @return 登录信息
     */
    AdminLoginVO login(AdminLoginDTO requestParam);


}
