package com.irum.teamup.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.irum.teamup.page.PageDTO;
import com.irum.teamup.po.UserDO;
import com.irum.teamup.query.UserPageQuery;
import com.irum.teamup.vo.user.UserVO;

public interface UserService extends IService<UserDO> {

    PageDTO<UserVO> getUserList(UserPageQuery userPageQuery);

}
