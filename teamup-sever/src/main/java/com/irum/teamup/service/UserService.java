package com.irum.teamup.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.irum.teamup.po.UserDO;
import com.irum.teamup.dto.UserLoginDTO;
import com.irum.teamup.dto.UserRegisterDTO;
import com.irum.teamup.dto.UserUpdateDTO;
import com.irum.teamup.vo.UserLoginVO;
import com.irum.teamup.vo.UserVO;

/**
 * @author irum
 * @date 2021/09/05
 */
public interface UserService extends IService<UserDO> {

    /**
     * 根据用户名查询用户信息
     *
     * @param username 用户名
     * @return 用户信息
     */
    UserVO getUserByUsername(String username);

    /**
     * 判断用户名是否存在
     *
     * @param username 用户名
     * @return true:存在 false:不存在
     */
    Boolean hasUsername(String username);

    /**
     * 注册用户
     *
     * @param requestParam 注册信息
     */
    void Register(UserRegisterDTO requestParam);

    /**
     * 更新用户信息
     *
     * @param requestParam 更新信息
     */
    void update(UserUpdateDTO requestParam);

    /**
     * 登录
     *
     * @param requestParam 登录信息
     * @return 登录信息
     */
    UserLoginVO login(UserLoginDTO requestParam);

    /**
     * 验证登录
     * @param token 登录token
     * @return true:登录成功 false:登录失败
     */
    Boolean checklogin(String username,String  token);
}
