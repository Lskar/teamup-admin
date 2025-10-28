package com.irum.teamup.service.Impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.irum.teamup.mapper.ResumeMapper;
import com.irum.teamup.po.ResumeDO;
import com.irum.teamup.query.ResumePageQuery;
import com.irum.teamup.service.ResumeService;
import com.irum.teamup.utils.BeanUtil;
import com.irum.teamup.vo.ResumeVO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ResumeServiceImpl extends ServiceImpl<ResumeMapper, ResumeDO> implements ResumeService {
    @Override
    public Page<ResumeVO> pageQuery(ResumePageQuery resumePageQuery) {
        return null;
    }

    @Override
    public ResumeVO getResumeById(Long id) {
        ResumeDO resumeDO = getById(id);
        return BeanUtil.convert(resumeDO, ResumeVO.class);
    }

    @Override
    public void updateResume(ResumeDO resumeDO) {
        updateById(resumeDO);
    }

    @Override
    public void deleteResume(Long id) {
        removeById(id);
    }

    @Override
    public void updateStatus(Long id, Integer status) {
        lambdaUpdate()
                .eq(ResumeDO::getId, id)
                .set(ResumeDO::getStatus, status)
                .update();
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
