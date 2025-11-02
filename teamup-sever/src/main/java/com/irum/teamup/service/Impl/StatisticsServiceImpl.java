package com.irum.teamup.service.Impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.irum.teamup.mapper.ProjectMapper;
import com.irum.teamup.mapper.ResumeDeliveryMapper;
import com.irum.teamup.mapper.ResumeMapper;
import com.irum.teamup.mapper.UserMapper;
import com.irum.teamup.po.ProjectDO;
import com.irum.teamup.po.UserDO;
import com.irum.teamup.service.StatisticsService;
import com.irum.teamup.vo.CollegeProjectStatsVO;
import com.irum.teamup.vo.PlatformOverviewVO;
import com.irum.teamup.vo.ProjectCategoryStatsVO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.swing.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;


@Service
@Slf4j
@RequiredArgsConstructor
public class StatisticsServiceImpl implements StatisticsService {

    private final UserMapper userMapper;

    private final ProjectMapper projectMapper;

    private final ResumeMapper resumeMapper;

    private final ResumeDeliveryMapper resumeDeliveryMapper;

    @Override
    public PlatformOverviewVO getPlatformOverview() {
        //统计用户数量(账号状态为0)
        Long totalUsers = userMapper.selectCount(new QueryWrapper<UserDO>().eq("status", 0));
        //统计项目数量
        Long totalProjects = projectMapper.selectCount(null);
        //统计简历投递数量
        Long totalResumeDeliveries = resumeDeliveryMapper.selectCount(null);
        //用户增长率
        //查询今日新增用户数量
        Long todayNewUsers = userMapper.selectCount(
                new QueryWrapper<UserDO>()
                        .ge("create_time", LocalDate.now()));
        Double growthRate = (todayNewUsers * 1.0 / totalUsers) * 100;
        //今日新增项目数
        Long NewProjects = projectMapper.selectCount(new QueryWrapper<ProjectDO>()
                .ge("created_time", LocalDate.now()));
        return new PlatformOverviewVO(totalUsers, totalProjects, totalResumeDeliveries, growthRate, NewProjects);
    }

    @Override
    public List<ProjectCategoryStatsVO> getProjectCategoryStats() {
        // 查询所有项目数量
        Long totalProjects = projectMapper.selectCount(null);

        // 查询各项目类型的统计信息
        List<ProjectCategoryStatsVO> categoryStats = projectMapper.selectProjectCountByCategory();

        // 计算各分类的占比
        if (totalProjects > 0) {
            for (ProjectCategoryStatsVO stats : categoryStats) {
                Double percentage = (stats.getCount() * 100.0) / totalProjects;
                stats.setPercentage(percentage);
            }
        }
        return categoryStats;
    }


    @Override
    public List<CollegeProjectStatsVO> getCollegeProjectStats() {
        // 调用 projectMapper 查询各学院的项目统计数据
        //todo 可能有bug
        return projectMapper.selectCollegeProjectStats();
    }

}
