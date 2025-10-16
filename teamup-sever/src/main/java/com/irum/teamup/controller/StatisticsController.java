package com.irum.teamup.controller;

import com.irum.teamup.po.CollegeProjectStats;
import com.irum.teamup.po.PlatformOverview;
import com.irum.teamup.po.ProjectCategoryStats;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/admin/statistics")
public class StatisticsController {


    // 获取平台运营数据概览
    @GetMapping("/overview")
    public ResponseEntity<PlatformOverview> getPlatformOverview() {

        return null;
    }

    // 获取项目分类统计
    @GetMapping("/project-category")
    public ResponseEntity<List<ProjectCategoryStats>> getProjectCategoryStats(){
        return null;
    }

    // 获取学院项目统计
    @GetMapping("/college-stats")
    public ResponseEntity<List<CollegeProjectStats>> getCollegeProjectStats() {
        return null;
    }
}