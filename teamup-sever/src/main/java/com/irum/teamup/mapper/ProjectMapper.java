// ProjectMapper.java
package com.irum.teamup.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.irum.teamup.po.ProjectDO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ProjectMapper extends BaseMapper<ProjectDO> {
}
