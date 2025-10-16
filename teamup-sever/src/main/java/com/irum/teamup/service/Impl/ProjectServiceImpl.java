package com.irum.teamup.service.Impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.irum.teamup.po.ProjectDO;
import com.irum.teamup.service.ProjectService;
import com.irum.teamup.vo.ProjectVO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProjectServiceImpl implements ProjectService {

    @Override
    public Page<ProjectVO> pageQuery(Integer currentPage, Integer pageSize, String status, String college, String projectType) {
        return null;
    }

    @Override
    public ProjectVO getProjectById(Long id) {
        return null;
    }

    @Override
    public void updateProject(ProjectDO projectDO) {

    }

    @Override
    public void deleteProject(Long id) {

    }

    @Override
    public void updateStatus(Long id, String status) {

    }
}
