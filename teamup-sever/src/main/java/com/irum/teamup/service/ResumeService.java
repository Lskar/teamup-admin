package com.irum.teamup.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.irum.teamup.po.ResumeDO;
import com.irum.teamup.query.ResumePageQuery;
import com.irum.teamup.vo.ResumeVO;

/**
 * 简历服务接口
 */
public interface ResumeService extends IService<ResumeDO> {
    
    /**
     * 分页查询简历投递列表
     * @return 简历分页结果
     */
    Page<ResumeVO> pageQuery(ResumePageQuery resumepageQuery);
    
    /**
     * 根据ID获取简历详情
     *
     * @param id 简历ID
     * @return 简历VO对象
     */
    ResumeVO getResumeById(Long id);
    
    /**
     * 更新简历信息
     *
     * @param resumeDO 简历DO对象
     */
    void updateResume(ResumeDO resumeDO);
    
    /**
     * 删除简历记录
     *
     * @param id 简历ID
     */
    void deleteResume(Long id);
    
    /**
     * 更新简历状态
     *
     * @param id 简历ID
     * @param status 新状态
     */
    void updateStatus(Long id, Integer status);
    
    /**
     * 统计各项目的简历投递数量
     *
     * @return 统计结果
     */
    Object getProjectResumeStatistics();
    
    /**
     * 导出简历数据
     *
     * @param status 状态筛选条件
     * @param projectId 项目ID筛选条件
     * @return 导出文件路径
     */
    String exportResumeData(String status, Long projectId);
}
