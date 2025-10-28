package com.irum.teamup.service.Impl;

import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.irum.teamup.dto.user.UserUpdateDTO;
import com.irum.teamup.mapper.UserMapper;
import com.irum.teamup.page.PageDTO;
import com.irum.teamup.po.UserDO;
import com.irum.teamup.query.UserPageQuery;
import com.irum.teamup.service.UserService;
import com.irum.teamup.utils.BeanUtil;
import com.irum.teamup.vo.user.UserDetailVO;
import com.irum.teamup.vo.user.UserVO;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, UserDO> implements UserService {

    @Override
    public PageDTO<UserVO> getUserList(UserPageQuery userPageQuery) {
        Page<UserDO> pageResult = lambdaQuery()
                .like(StrUtil.isNotBlank(userPageQuery.getUsername()), UserDO::getUsername, userPageQuery.getUsername())
                .eq(StrUtil.isNotBlank(userPageQuery.getSid()), UserDO::getSid, userPageQuery.getSid())
                .like(StrUtil.isNotBlank(userPageQuery.getCollege()), UserDO::getCollege, userPageQuery.getCollege())
                .like(StrUtil.isNotBlank(userPageQuery.getMajor()), UserDO::getMajor, userPageQuery.getMajor())
                .eq(userPageQuery.getStatus() != null, UserDO::getStatus, userPageQuery.getStatus())
                .page(userPageQuery.toMpPage(userPageQuery.getSortBy(), userPageQuery.getIsAsc()));

        return PageDTO.of(pageResult, UserVO.class);
    }

    @Override
    public UserDetailVO getUserDetail(Long id) {
        UserDO userDO = getById(id);
        return BeanUtil.convert(userDO, UserDetailVO.class);
    }

    @Override
    public void updateUserStatus(Long id, Integer status) {
        lambdaUpdate()
                .eq(UserDO::getId, id)
                .set(UserDO::getStatus, status)
                .update();
    }

    @Override
    public void updateUser(UserUpdateDTO userUpdateDTO) {

        updateById(BeanUtil.convert(userUpdateDTO, UserDO.class));
    }


}
