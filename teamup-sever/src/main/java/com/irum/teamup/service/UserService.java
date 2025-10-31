package com.irum.teamup.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.irum.teamup.dto.user.UserUpdateDTO;
import com.irum.teamup.page.PageDTO;
import com.irum.teamup.po.UserDO;
import com.irum.teamup.query.UserPageQuery;
import com.irum.teamup.vo.user.UserDetailVO;
import com.irum.teamup.vo.user.UserVO;

public interface UserService extends IService<UserDO> {

    PageDTO<UserVO> getUserList(UserPageQuery userPageQuery);

    UserDetailVO getUserDetail(Long id);

    void updateUserStatus(Long id, Integer status);

    void updateUser(UserUpdateDTO userUpdateDTO);

    void deleteUserById(Long id);
}
