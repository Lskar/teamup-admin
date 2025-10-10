package com.irum.teamup.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.irum.teamup.po.UserDO;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author irum
 * @date 2021/8/23
 **/
@Mapper
public interface UserMapper extends BaseMapper<UserDO> {
}
