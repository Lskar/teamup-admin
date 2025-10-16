package com.irum.teamup.controller;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.irum.teamup.convention.result.Result;
import com.irum.teamup.convention.result.Results;
import com.irum.teamup.enums.ProjectErrorCodeEnum;
import com.irum.teamup.po.ProjectDO;
import com.irum.teamup.service.ProjectService;
import com.irum.teamup.vo.ProjectVO;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

/**
 * 项目控制层
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/team-up/v1/project")
public class ProjectController {

    private final ProjectService projectService;

    /**
     * 分页查询项目列表
     */
    @GetMapping("/page")
    @ApiOperation(value = "分页查询项目列表", notes = "分页查询项目列表")
    public Result<Page<ProjectVO>> pageQuery(
            @RequestParam(defaultValue = "1") Integer currentPage,
            @RequestParam(defaultValue = "10") Integer pageSize,
            @RequestParam(required = false) String status,
            @RequestParam(required = false) String college,
            @RequestParam(required = false) String projectType) {

        Page<ProjectVO> result = projectService.pageQuery(currentPage, pageSize, status, college, projectType);
        return Results.success(result);
    }

    /**
     * 根据ID获取项目详情
     */
    @GetMapping("/{id}")
    @ApiOperation(value = "根据ID获取项目详情", notes = "根据ID获取项目详情")
    @ApiImplicitParam(name = "id", value = "项目ID", required = true, dataType = "Long", paramType = "path")
    public Result<ProjectVO> getProjectById(@PathVariable("id") Long id) {
        ProjectVO result = projectService.getProjectById(id);
        if (result == null) {
            return new Result<ProjectVO>()
                    .setCode(ProjectErrorCodeEnum.PROJECT_NOT_FOUND.code())
                    .setMessage(ProjectErrorCodeEnum.PROJECT_NOT_FOUND.message());
        }
        return Results.success(result);
    }

    /**
     * 更新项目信息
     */
    @PutMapping("/{id}")
    @ApiOperation(value = "更新项目信息", notes = "更新项目信息")
    @ApiImplicitParam(name = "id", value = "项目ID", required = true, dataType = "Long", paramType = "path")
    public Result<Void> updateProject(@PathVariable("id") Long id, @RequestBody ProjectDO projectDO) {
        projectDO.setId(id);
        projectService.updateProject(projectDO);
        return Results.success();
    }

    /**
     * 删除项目
     */
    @DeleteMapping("/{id}")
    @ApiOperation(value = "删除项目", notes = "删除项目")
    @ApiImplicitParam(name = "id", value = "项目ID", required = true, dataType = "Long", paramType = "path")
    public Result<Void> deleteProject(@PathVariable("id") Long id) {
        projectService.deleteProject(id);
        return Results.success();
    }

    /**
     * 修改项目状态
     */
    @PutMapping("/{id}/status")
    @ApiOperation(value = "修改项目状态", notes = "修改项目状态")
    public Result<Void> updateStatus(@PathVariable("id") Long id, @RequestParam("status") String status) {
        projectService.updateStatus(id, status);
        return Results.success();
    }
}
