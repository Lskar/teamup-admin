package com.irum.teamup.service;

import com.irum.teamup.page.PageDTO;
import com.irum.teamup.po.ProjectDO;
import com.irum.teamup.query.ProjectPageQuery;
import com.irum.teamup.vo.ResumeVO;
import com.irum.teamup.vo.project.ProjectVO;

import java.util.List;

public interface ProjectService {

    PageDTO<ProjectVO> pageQuery(ProjectPageQuery projectPageQuery);

    ProjectVO getProjectById(Long id);

    void updateProject(ProjectDO projectDO);

    void deleteProject(Long id);

    void updateStatus(Long id, Integer status);

    List<ResumeVO> getResumeByProjectId(Long projectId);
}
