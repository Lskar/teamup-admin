package com.irum.teamup.controller;

import com.irum.teamup.convention.result.ResponseResult;
import com.irum.teamup.service.StatisticsService;
import com.irum.teamup.vo.CollegeProjectStatsVO;
import com.irum.teamup.vo.PlatformOverviewVO;
import com.irum.teamup.vo.ProjectCategoryStatsVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/admin/statistics")
@Api(tags = "数据统计管理")
public class StatisticsController {
    private final StatisticsService statisticsService;


    // 获取平台运营数据概览
    @ApiOperation("获取平台运营数据概览")
    @GetMapping("/overview")
    public ResponseResult<PlatformOverviewVO> getPlatformOverview() {
        return ResponseResult.success( statisticsService.getPlatformOverview());
    }

    // 获取项目分类统计
    @GetMapping("/project-category")
    @ApiOperation("获取项目分类统计")
    public ResponseResult<List<ProjectCategoryStatsVO>> getProjectCategoryStats(){
        return ResponseResult.success(statisticsService.getProjectCategoryStats());
    }

    // 获取学院项目统计
    @GetMapping("/college-stats")
    @ApiOperation("获取学院项目统计")
    public ResponseResult<List<CollegeProjectStatsVO>> getCollegeProjectStats() {
        return ResponseResult.success( statisticsService.getCollegeProjectStats());
    }
}