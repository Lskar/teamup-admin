package com.irum.teamup.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.irum.teamup.dto.PageQueryDTO;
import com.irum.teamup.po.ProjectDO;
import com.irum.teamup.vo.ProjectVO;

public interface ProjectService {
    
    Page<ProjectVO> pageQuery(PageQueryDTO pageQueryDTO);

    ProjectVO getProjectById(Long id);

    void updateProject(ProjectDO projectDO);

    void deleteProject(Long id);

    void updateStatus(Long id, String status);
}
