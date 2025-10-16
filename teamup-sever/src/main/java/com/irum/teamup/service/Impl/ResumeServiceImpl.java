package com.irum.teamup.service.Impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.irum.teamup.po.ResumeDO;
import com.irum.teamup.service.ResumeService;
import com.irum.teamup.vo.ResumeVO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ResumeServiceImpl implements ResumeService {
    @Override
    public Page<ResumeVO> pageQuery(Integer currentPage, Integer pageSize, String status, Long applicantId, Long projectId) {
        return null;
    }

    @Override
    public ResumeVO getResumeById(Long id) {
        return null;
    }

    @Override
    public void updateResume(ResumeDO resumeDO) {

    }

    @Override
    public void deleteResume(Long id) {

    }

    @Override
    public void updateStatus(Long id, String status) {

    }

    @Override
    public Object getProjectResumeStatistics() {
        return null;
    }

    @Override
    public String exportResumeData(String status, Long projectId) {
        return "";
    }
}
