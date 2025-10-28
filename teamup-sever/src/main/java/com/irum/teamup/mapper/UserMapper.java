package com.irum.teamup.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.irum.teamup.po.UserDO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper extends BaseMapper<UserDO> {
}
