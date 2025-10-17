package com.irum.teamup.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

/**
 * 简历信息VO
 */
@Data
@ApiModel(value = "简历信息VO")
public class ResumeVO {
    
    /**
     * 主键ID
     */
    @ApiModelProperty(value = "主键ID")
    private Long id;
    
    /**
     * 申请人ID
     */
    @ApiModelProperty(value = "申请人ID")
    private Long applicantId;
    
    /**
     * 申请人姓名（冗余字段，便于展示）
     */
    @ApiModelProperty(value = "申请人姓名")
    private String applicantName;
    
    /**
     * 项目ID
     */
    @ApiModelProperty(value = "项目ID")
    private Long projectId;
    
    /**
     * 项目标题（冗余字段，便于展示）
     */
    @ApiModelProperty(value = "项目标题")
    private String projectTitle;
    
    /**
     * 简历标题
     */
    @ApiModelProperty(value = "简历标题")
    private String resumeTitle;
    
    /**
     * 简历详细内容
     */
    @ApiModelProperty(value = "简历详细内容")
    private String resumeContent;
    
    /**
     * 简历文件存储路径
     */
    @ApiModelProperty(value = "简历文件存储路径")
    private String resumeFilePath;
    
    /**
     * 文件格式：PDF, DOC, DOCX等
     */
    @ApiModelProperty(value = "文件格式")
    private String fileFormat;
    
    /**
     * 文件大小(字节)
     */
    @ApiModelProperty(value = "文件大小")
    private Long fileSize;
    
    /**
     * 投递状态：DELIVERED-已投递, VIEWED-已查看, ACCEPTED-已录取, REJECTED-已拒绝
     */
    @ApiModelProperty(value = "投递状态")
    private String status;
    
    /**
     * 创建时间
     */
    @ApiModelProperty(value = "创建时间")
    private Date createdTime;
    
    /**
     * 更新时间
     */
    @ApiModelProperty(value = "更新时间")
    private Date updatedTime;
}
