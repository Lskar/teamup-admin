package com.irum.teamup.po;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import java.util.Date;

/**
 * 简历信息DO
 */
@Data
@TableName("resume")
public class ResumeDO {
    
    /**
     * 主键ID
     */
    private Long id;
    
    /**
     * 申请人ID
     */
    private Long applicantId;
    
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
     * 创建时间
     */
    private Date createdTime;
    
    /**
     * 更新时间
     */
    private Date updatedTime;
    
    /**
     * 简历状态0：未删除 1：已删除
     */
    private Integer status;
}
