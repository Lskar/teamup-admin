package com.irum.teamup.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.irum.teamup.convention.result.ResponseResult;
import com.irum.teamup.po.ResumeDO;
import com.irum.teamup.query.ResumePageQuery;
import com.irum.teamup.service.ResumeService;
import com.irum.teamup.vo.ResumeVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

/**
 * 简历投递控制层
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/team-up/v1/resume")
@Api(tags = "简历投递管理")
public class ResumeController {

    private final ResumeService resumeService;

    /**
     * 分页查询简历投递列表
     */
    @GetMapping("/page")
    @ApiOperation(value = "分页查询简历投递列表")
    public ResponseResult<Page<ResumeVO>> pageQuery(ResumePageQuery resumePageQuery) {


        return null;
    }

    /**
     * 根据ID获取简历投递详情
     */
    @GetMapping("/{id}")
    @ApiOperation(value = "根据ID获取简历投递详情")
    @ApiImplicitParam(name = "id", value = "简历ID", required = true, dataType = "Long", paramType = "path")
    public ResponseResult<ResumeVO> getResumeById(@PathVariable("id") Long id) {

        return ResponseResult.success(resumeService.getResumeById(id));
    }

    /**
     * 更新简历投递信息
     */
    @PutMapping("/{id}")
    @ApiOperation(value = "更新简历投递信息")
    @ApiImplicitParam(name = "id", value = "简历ID", required = true, dataType = "Long", paramType = "path")
    public ResponseResult<Void> updateResume(@PathVariable("id") Long id, @RequestBody ResumeDO resumeDO) {
        resumeDO.setId(id);
        resumeService.updateResume(resumeDO);
        return ResponseResult.success();
    }

    /**
     * 删除简历投递记录
     */
    @DeleteMapping("/{id}")
    @ApiOperation(value = "删除简历投递记录")
    @ApiImplicitParam(name = "id", value = "简历ID", required = true, dataType = "Long", paramType = "path")
    public ResponseResult<Void> deleteResume(@PathVariable("id") Long id) {
        resumeService.deleteResume(id);
        return ResponseResult.success();
    }

    /**
     * 修改简历投递状态
     */
    @PutMapping("/{id}/status")
    @ApiOperation(value = "修改简历投递状态")
    public ResponseResult<Void> updateStatus(@PathVariable("id") Long id, @RequestParam("status") Integer status) {
        resumeService.updateStatus(id, status);
        return ResponseResult.success();
    }

    /**
     * 统计各项目的简历投递数量
     */
    @GetMapping("/statistics/project")
    @ApiOperation(value = "统计各项目的简历投递数量")
    public ResponseResult<Object> getProjectResumeStatistics() {

        return ResponseResult.success(resumeService.getProjectResumeStatistics());
    }

    /**
     * 导出简历投递数据
     */
    @GetMapping("/export")
    @ApiOperation(value = "导出简历投递数据")
    public ResponseResult<String> exportResumeData(
            @RequestParam(required = false) String status,
            @RequestParam(required = false) Long projectId) {
        String exportPath = resumeService.exportResumeData(status, projectId);
        return ResponseResult.success(exportPath);
    }
}
