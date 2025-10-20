package com.irum.teamup.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.irum.teamup.convention.result.Result;
import com.irum.teamup.convention.result.Results;
import com.irum.teamup.enums.ResumeErrorCodeEnum;
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
    @ApiOperation(value = "分页查询简历投递列表", notes = "分页查询简历投递列表")
    public Result<Page<ResumeVO>> pageQuery(ResumePageQuery resumePageQuery) {


        return null;
    }

    /**
     * 根据ID获取简历投递详情
     */
    @GetMapping("/{id}")
    @ApiOperation(value = "根据ID获取简历投递详情", notes = "根据ID获取简历投递详情")
    @ApiImplicitParam(name = "id", value = "简历ID", required = true, dataType = "Long", paramType = "path")
    public Result<ResumeVO> getResumeById(@PathVariable("id") Long id) {
        ResumeVO result = resumeService.getResumeById(id);
        if (result == null) {
            return new Result<ResumeVO>()
                    .setCode(ResumeErrorCodeEnum.RESUME_NOT_FOUND.code())
                    .setMessage(ResumeErrorCodeEnum.RESUME_NOT_FOUND.message());
        }
        return Results.success(result);
    }

    /**
     * 更新简历投递信息
     */
    @PutMapping("/{id}")
    @ApiOperation(value = "更新简历投递信息", notes = "更新简历投递信息")
    @ApiImplicitParam(name = "id", value = "简历ID", required = true, dataType = "Long", paramType = "path")
    public Result<Void> updateResume(@PathVariable("id") Long id, @RequestBody ResumeDO resumeDO) {
        resumeDO.setId(id);
        resumeService.updateResume(resumeDO);
        return Results.success();
    }

    /**
     * 删除简历投递记录
     */
    @DeleteMapping("/{id}")
    @ApiOperation(value = "删除简历投递记录", notes = "删除简历投递记录")
    @ApiImplicitParam(name = "id", value = "简历ID", required = true, dataType = "Long", paramType = "path")
    public Result<Void> deleteResume(@PathVariable("id") Long id) {
        resumeService.deleteResume(id);
        return Results.success();
    }

    /**
     * 修改简历投递状态
     */
    @PutMapping("/{id}/status")
    @ApiOperation(value = "修改简历投递状态", notes = "修改简历投递状态")
    public Result<Void> updateStatus(@PathVariable("id") Long id, @RequestParam("status") String status) {
        resumeService.updateStatus(id, status);
        return Results.success();
    }

    /**
     * 统计各项目的简历投递数量
     */
    @GetMapping("/statistics/project")
    @ApiOperation(value = "统计各项目的简历投递数量", notes = "统计各项目的简历投递数量")
    public Result<Object> getProjectResumeStatistics() {
        Object result = resumeService.getProjectResumeStatistics();
        return Results.success(result);
    }

    /**
     * 导出简历投递数据
     */
    @GetMapping("/export")
    @ApiOperation(value = "导出简历投递数据", notes = "导出简历投递数据用于统计分析")
    public Result<String> exportResumeData(
            @RequestParam(required = false) String status,
            @RequestParam(required = false) Long projectId) {
        String exportPath = resumeService.exportResumeData(status, projectId);
        return Results.success(exportPath);
    }
}
