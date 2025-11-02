package com.irum.teamup.service;

import com.irum.teamup.vo.CollegeProjectStatsVO;
import com.irum.teamup.vo.PlatformOverviewVO;
import com.irum.teamup.vo.ProjectCategoryStatsVO;

import java.util.List;

public interface StatisticsService {
    /**
     * 获取平台总览信息
     *
     * @return 平台总览信息
     */
    PlatformOverviewVO getPlatformOverview();

    /**
     * 获取项目类别统计信息
     *
     * @return 项目类别统计信息
     */
    List<ProjectCategoryStatsVO> getProjectCategoryStats();

    /**
     * 获取学院项目统计信息
     *
     * @return 学院项目统计信息
     */
    List<CollegeProjectStatsVO> getCollegeProjectStats();
}
