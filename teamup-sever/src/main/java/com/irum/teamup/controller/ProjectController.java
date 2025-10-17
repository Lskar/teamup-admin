package com.irum.teamup.controller;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.irum.teamup.convention.result.Result;
import com.irum.teamup.convention.result.Results;
import com.irum.teamup.enums.ProjectErrorCodeEnum;
import com.irum.teamup.po.ProjectDO;
import com.irum.teamup.query.ProjectPageQuery;
import com.irum.teamup.service.ProjectService;
import com.irum.teamup.vo.project.ProjectVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

/**
 * 项目控制层
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/team-up/v1/project")
@Api(tags = "项目管理接口")
public class ProjectController {


    private final ProjectService projectService;


    /**
     * 分页查询项目列表
     */
    @GetMapping("/page")
    @ApiOperation(value = "分页查询项目列表", notes = "分页查询项目列表")
    @ApiImplicitParam(name = "pageQueryDTO", value = "分页查询参数", required = true, dataType = "PageQueryDTO", paramType = "body")
    public Result<Page<ProjectVO>> pageQuery(@RequestParam ProjectPageQuery projectPageQuery) {
        return null;
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
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "项目ID", required = true, dataType = "Long", paramType = "path"),
            @ApiImplicitParam(name = "projectDO", value = "项目信息", required = true, dataType = "ProjectDO", paramType = "body")
    })
    public Result<Void> updateProject(@PathVariable("id") Long id, @RequestBody ProjectDO projectDO) {
        return null;
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
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "项目ID", required = true, dataType = "Long", paramType = "path"),
            @ApiImplicitParam(name = "status", value = "项目状态", required = true, dataType = "String", paramType = "query")
    })
    public Result<Void> updateStatus(@PathVariable("id") Long id, @RequestParam("status") String status) {
        projectService.updateStatus(id, status);
        return Results.success();
    }
}
