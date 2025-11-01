package com.irum.teamup.mapper;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.irum.teamup.po.ResumeDO;
import com.irum.teamup.po.ResumeDeliveryDO;
import com.irum.teamup.vo.project.ProjectResumeStatisticsVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface ResumeMapper extends BaseMapper<ResumeDO> {
    // 查询各项目的简历投递数量统计
    @Select("SELECT rd.project_id AS projectId, COUNT(*) AS resumeCount " +
            "FROM resume_delivery rd " +
            "LEFT JOIN project p ON rd.project_id = p.id " +
            "GROUP BY rd.project_id " +
            "ORDER BY resumeCount DESC")
    List<ProjectResumeStatisticsVO> selectProjectResumeStatistics();
}