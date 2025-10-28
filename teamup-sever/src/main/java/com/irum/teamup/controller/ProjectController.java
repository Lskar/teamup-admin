package com.irum.teamup.controller;


import com.irum.teamup.convention.result.Result;
import com.irum.teamup.convention.result.Results;
import com.irum.teamup.dto.project.ProjectUpdateDTO;
import com.irum.teamup.enums.ProjectErrorCodeEnum;
import com.irum.teamup.page.PageDTO;
import com.irum.teamup.po.ProjectDO;
import com.irum.teamup.query.ProjectPageQuery;
import com.irum.teamup.service.ProjectService;
import com.irum.teamup.vo.project.ProjectVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

/**
 * 项目控制层
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/team-up/v1/project")
@Slf4j
@Api(tags = "项目管理接口")
public class ProjectController {


    private final ProjectService projectService;


    /**
     * 分页查询项目列表
     */
    @GetMapping("/page")
    @ApiOperation(value = "分页查询项目列表", notes = "")
    @ApiImplicitParam(name = "pageQueryDTO", value = "分页查询参数", required = true, dataType = "PageQueryDTO", paramType = "body")
    public Result<PageDTO<ProjectVO>> pageQuery(ProjectPageQuery projectPageQuery) {
        return Results.success(projectService.pageQuery(projectPageQuery));
    }


    /**
     * 根据ID获取项目详情
     */
    @GetMapping("/{id}")
    @ApiOperation(value = "根据ID获取项目详情", notes = "")
    @ApiImplicitParam(name = "id", value = "项目ID", required = true, dataType = "Long", paramType = "path")
    public Result<ProjectVO> getProjectById(@PathVariable("id") Long id) {
        log.info("根据ID获取项目详情开始, 项目ID: {}", id);
        ProjectVO result = projectService.getProjectById(id);
        if (result == null) {
            log.warn("根据ID获取项目详情失败, 项目不存在, 项目ID: {}", id);
            return new Result<ProjectVO>()
                    .setCode(ProjectErrorCodeEnum.PROJECT_NOT_FOUND.code())
                    .setMessage(ProjectErrorCodeEnum.PROJECT_NOT_FOUND.message());
        }
        log.info("根据ID获取项目详情成功, 项目ID: {}", id);
        return Results.success(result);
    }



    /**
     * 更新项目信息
     */
    @PutMapping
    @ApiOperation(value = "更新项目信息", notes = "")
    @ApiImplicitParam(name = "projectUpdateDTO", value = "项目更新参数", required = true, dataType = "ProjectUpdateDTO", paramType = "body")
    public Result<Void> updateProject(@RequestBody ProjectUpdateDTO projectUpdateDTO) {
        log.info("更新项目信息开始, 项目ID: {}", projectUpdateDTO.getId());
        // 将 DTO 转换为 DO 对象
        ProjectDO projectDO = com.irum.teamup.utils.BeanUtils.copyBean(projectUpdateDTO, ProjectDO.class);

        // 调用服务层更新项目
        try {
            projectService.updateProject(projectDO);
            log.info("更新项目信息成功, 项目ID: {}", projectUpdateDTO.getId());
            return Results.success();
        } catch (RuntimeException e) {
            log.error("更新项目信息失败, 项目ID: {}, 错误信息: {}", projectUpdateDTO.getId(), e.getMessage(), e);
            return Results.failure(ProjectErrorCodeEnum.PROJECT_UPDATE_ERROR.code(), e.getMessage());
        }
    }


    /**
     * 删除项目
     */
    @DeleteMapping("/{id}")
    @ApiOperation(value = "删除项目", notes = "")
    @ApiImplicitParam(name = "id", value = "项目ID", required = true, dataType = "Long", paramType = "path")
    public Result<Void> deleteProject(@PathVariable("id") Long id) {
        log.info("删除项目开始, 项目ID: {}", id);
        projectService.deleteProject(id);
        log.info("删除项目成功, 项目ID: {}", id);
        return Results.success();
    }


    /**
     * 修改项目状态
     */
    @PutMapping("/{id}/status")
    @ApiOperation(value = "修改项目状态", notes = "")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "项目ID", required = true, dataType = "Long", paramType = "path"),
            @ApiImplicitParam(name = "status", value = "项目状态", required = true, dataType = "String", paramType = "query")
    })
    public Result<Void> updateStatus(@PathVariable("id") Long id, @RequestParam("status") String status) {
        log.info("修改项目状态开始, 项目ID: {}, 新状态: {}", id, status);
        projectService.updateStatus(id, status);
        log.info("修改项目状态成功, 项目ID: {}, 新状态: {}", id, status);
        return Results.success();
    }


}
