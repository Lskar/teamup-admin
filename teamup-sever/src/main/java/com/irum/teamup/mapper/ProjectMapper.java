// ProjectMapper.java
package com.irum.teamup.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.irum.teamup.po.ProjectDO;
import com.irum.teamup.vo.CollegeProjectStatsVO;
import com.irum.teamup.vo.ProjectCategoryStatsVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface ProjectMapper extends BaseMapper<ProjectDO> {
    @Select("    SELECT \n" +
            "        project_type as category,\n" +
            "        COUNT(*) as count\n" +
            "    FROM project \n" +
            "    GROUP BY project_type")
    List<ProjectCategoryStatsVO> selectProjectCountByCategory();

    @Select("SELECT \n" +
            "        college,\n" +
            "        COUNT(*) as projectCount,\n" +
            "        SUM(current_members) as userCount\n" +
            "    FROM project \n" +
            "    WHERE college IS NOT NULL AND college != ''\n" +
            "    GROUP BY college")
    List<CollegeProjectStatsVO> selectCollegeProjectStats();

}
