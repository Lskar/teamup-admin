package com.irum.teamup.vo;

import lombok.Data;
import java.util.Date;

/**
 * 简历信息VO
 */
@Data
public class ResumeVO {
    
    /**
     * 主键ID
     */
    private Long id;
    
    /**
     * 申请人ID
     */
    private Long applicantId;
    
    /**
     * 申请人姓名（冗余字段，便于展示）
     */
    private String applicantName;
    
    /**
     * 项目ID
     */
    private Long projectId;
    
    /**
     * 项目标题（冗余字段，便于展示）
     */
    private String projectTitle;
    
    /**
     * 简历标题
     */
    private String resumeTitle;
    
    /**
     * 简历详细内容
     */
    private String resumeContent;
    
    /**
     * 简历文件存储路径
     */
    private String resumeFilePath;
    
    /**
     * 文件格式：PDF, DOC, DOCX等
     */
    private String fileFormat;
    
    /**
     * 文件大小(字节)
     */
    private Long fileSize;
    
    /**
     * 投递状态：DELIVERED-已投递, VIEWED-已查看, ACCEPTED-已录取, REJECTED-已拒绝
     */
    private String status;
    
    /**
     * 创建时间
     */
    private Date createdTime;
    
    /**
     * 更新时间
     */
    private Date updatedTime;
}
