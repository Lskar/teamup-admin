package com.irum.teamup.service.Impl;
import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.irum.teamup.mapper.ResumeDeliveryMapper;
import com.irum.teamup.mapper.ResumeMapper;
import com.irum.teamup.page.PageDTO;
import com.irum.teamup.po.ResumeDO;
import com.irum.teamup.po.ResumeDeliveryDO;
import com.irum.teamup.query.ResumePageQuery;
import com.irum.teamup.service.ResumeService;
import com.irum.teamup.utils.BeanUtil;
import com.irum.teamup.vo.ResumeVO;
import lombok.RequiredArgsConstructor;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class ResumeServiceImpl extends ServiceImpl<ResumeMapper, ResumeDO> implements ResumeService {

    private final ResumeDeliveryMapper resumeDeliveryMapper;

    @Override
    public PageDTO<ResumeVO> pageQuery(ResumePageQuery resumePageQuery) {

        Page<ResumeDO> pageResult = lambdaQuery()
                .like(StrUtil.isNotBlank(resumePageQuery.getResumeTitle()), ResumeDO::getResumeTitle, resumePageQuery.getResumeTitle())
                .eq(resumePageQuery.getStatus() != null, ResumeDO::getStatus, resumePageQuery.getStatus())
                .eq(resumePageQuery.getApplicantId() != null, ResumeDO::getApplicantId, resumePageQuery.getApplicantId())
                .page(resumePageQuery.toMpPage(resumePageQuery.getSortBy(), resumePageQuery.getIsAsc()));

        return PageDTO.of(pageResult,ResumeVO.class);
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
        return baseMapper.selectProjectResumeStatistics();
    }

    @Override
    public String exportResumeData(String status, Long projectId) {
        // 构建查询条件

        LambdaQueryWrapper<ResumeDeliveryDO> queryWrapper = new LambdaQueryWrapper<>();

        // 根据状态筛选
        if (status != null && !status.isEmpty()) {
            // 假设需要关联ResumeDO表进行状态查询
            // 这里可能需要调整具体实现，取决于实际需求
        }

        // 根据项目ID筛选
        if (projectId != null) {
            queryWrapper.eq(ResumeDeliveryDO::getProjectId, projectId);
        }

        // 查询数据
        List<ResumeDeliveryDO> resumeDeliveries = resumeDeliveryMapper.selectList(queryWrapper);

        // 创建导出文件路径
        String fileName = "resume_export_" + System.currentTimeMillis() + ".csv";
        String filePath = System.getProperty("user.dir") + "/exports/" + fileName;

        // 确保目录存在
        File exportDir = new File(System.getProperty("user.dir") + "/exports");
        if (!exportDir.exists()) {
            exportDir.mkdirs();
        }

        try (FileWriter fileWriter = new FileWriter(filePath);
             CSVPrinter csvPrinter = new CSVPrinter(fileWriter, CSVFormat.DEFAULT
                     .withHeader("ID", "Project ID", "Applicant ID", "Delivery Time", "Status"))) {

            // 写入数据
            for (ResumeDeliveryDO delivery : resumeDeliveries) {
                csvPrinter.printRecord(
                        delivery.getId(),
                        delivery.getProjectId(),
                        delivery.getApplicantId(),
                        delivery.getDeliveryTime(),
                        delivery.getStatus()
                );
            }

            return filePath;
        } catch (IOException e) {
            throw new RuntimeException("导出简历数据失败", e);
        }
    }

}
