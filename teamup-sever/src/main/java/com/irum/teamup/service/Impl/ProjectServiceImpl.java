package com.irum.teamup.service.Impl;


import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.irum.teamup.convention.exception.ProjectException;
import com.irum.teamup.enums.ProjectErrorCodeEnum;
import com.irum.teamup.mapper.ProjectMapper;
import com.irum.teamup.page.PageDTO;
import com.irum.teamup.po.ProjectDO;
import com.irum.teamup.query.ProjectPageQuery;
import com.irum.teamup.service.ProjectService;
import com.irum.teamup.vo.project.ProjectVO;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
@RequiredArgsConstructor
public class ProjectServiceImpl implements ProjectService {

    private final ProjectMapper projectMapper;

    /**
     * 分页查询项目列表，支持多条件过滤和排序
     */
    public PageDTO<ProjectVO> pageQuery(ProjectPageQuery projectPageQuery) {
        // 1. 使用父类 PageQuery 的 toMpPage 方法，设置默认排序为 created_time 降序
        Page<ProjectDO> mpPage = projectPageQuery.toMpPageDefaultSortByCreateTimeDesc();

        // 2. 构建查询条件
        QueryWrapper<ProjectDO> queryWrapper = new QueryWrapper<>();

        // 标题：模糊查询
        if (StrUtil.isNotEmpty(projectPageQuery.getTitle())) {
            queryWrapper.like("title", projectPageQuery.getTitle());
        }

        // 项目类型
        if (StrUtil.isNotEmpty(projectPageQuery.getProjectType())) {
            queryWrapper.eq("project_type", projectPageQuery.getProjectType());
        }

        // 所属学院
        if (StrUtil.isNotEmpty(projectPageQuery.getCollege())) {
            queryWrapper.eq("college", projectPageQuery.getCollege());
        }

        // 相关专业：模糊匹配
        if (StrUtil.isNotEmpty(projectPageQuery.getMajor())) {
            queryWrapper.like("major", projectPageQuery.getMajor());
        }

        // 状态
        if (StrUtil.isNotEmpty(projectPageQuery.getStatus())) {
            queryWrapper.eq("status", projectPageQuery.getStatus());
        }

        // 创建者ID
        if (projectPageQuery.getCreatorId() != null) {
            queryWrapper.eq("creator_id", projectPageQuery.getCreatorId());
        }

        // 团队规模
        if (projectPageQuery.getTeamSize() != null) {
            queryWrapper.eq("team_size", projectPageQuery.getTeamSize());
        }

        // 当前成员数
        if (projectPageQuery.getCurrentMembers() != null) {
            queryWrapper.eq("current_members", projectPageQuery.getCurrentMembers());
        }

        // 开始时间 >= startTime
        if (projectPageQuery.getStartTime() != null) {
            queryWrapper.ge("start_time", projectPageQuery.getStartTime());
        }

        // 结束时间 <= endTime
        if (projectPageQuery.getEndTime() != null) {
            queryWrapper.le("end_time", projectPageQuery.getEndTime());
        }

        // 3. 执行分页查询
        Page<ProjectDO> resultPage = projectMapper.selectPage(mpPage, queryWrapper);

        // 4. 转换为 PageDTO 结果
        return PageDTO.of(resultPage, ProjectVO.class);
    }


    /**
     * 将ProjectDO转换为ProjectVO
     */
    private ProjectVO convertToVO(ProjectDO projectDO) {
        ProjectVO projectVO = new ProjectVO();
        BeanUtils.copyProperties(projectDO, projectVO);
        return projectVO;
    }


    @Override
    public ProjectVO getProjectById(Long id) {
        // 查询项目信息
        ProjectDO projectDO = projectMapper.selectById(id);
        // 如果项目不存在，返回null（由控制器处理错误响应）
        if (projectDO == null) {
            throw new ProjectException(ProjectErrorCodeEnum.PROJECT_NOT_FOUND.code(), "项目不存在");
        }

        // 检查项目是否已被删除
        if ("DELETED".equals(projectDO.getStatus())) {
            return null;
        }

        // 转换为VO对象并返回
        return convertToVO(projectDO);
    }


    @Override
    public void updateProject(ProjectDO projectDO) {
        // 检查项目是否存在
        ProjectDO existingProject = projectMapper.selectById(projectDO.getId());
        if (existingProject == null) {
            throw new RuntimeException("项目不存在");
        }

        // 检查项目是否已被删除
        if ("DELETED".equals(existingProject.getStatus())) {
            throw new RuntimeException("项目已删除");
        }

        // 设置更新时间
        projectDO.setUpdatedTime(new Date());

        // 执行更新操作
        projectMapper.updateById(projectDO);
    }


    @Override
    public void deleteProject(Long id) {
        // 检查项目是否存在
        ProjectDO projectDO = projectMapper.selectById(id);
        if (projectDO == null) {
            throw new RuntimeException("项目不存在");
        }
        //实现逻辑删除
        projectDO.setStatus("DELETED");
        // 执行删除操作
        projectMapper.updateById(projectDO);
    }


    @Override
    public void updateStatus(Long id, String status) {
        // 检查项目是否存在
        ProjectDO projectDO = projectMapper.selectById(id);
        if (projectDO == null) {
            throw new RuntimeException("项目不存在");
        }
        //检查项目状态是否为已删除
        if ("DELETED".equals(projectDO.getStatus())) {
            throw new RuntimeException("项目已删除");
        }
        // 更新项目状态
        projectDO.setStatus(status);
        projectDO.setUpdatedTime(new Date()); // 更新时间

        // 执行更新操作
        projectMapper.updateById(projectDO);
    }
}
