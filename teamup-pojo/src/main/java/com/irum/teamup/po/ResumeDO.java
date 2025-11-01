package com.irum.teamup.po;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

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
    @TableId(type = IdType.AUTO)
    @ApiModelProperty(value = "主键ID")
    private Long id;
    
    /**
     * 申请人ID
     */
    @ApiModelProperty(value = "申请人ID")
    private Long applicantId;
    
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

    @ApiModelProperty(value = "文件格式：PDF, DOC, DOCX等")
    private String fileFormat;
    
    /**
     * 文件大小(字节)
     */
    @ApiModelProperty(value = "文件大小(字节)")
    private Long fileSize;
    
    /**
     * 创建时间
     */
    @ApiModelProperty(value = "创建时间")
    private Data createdTime;
    
    /**
     * 更新时间
     */
    @ApiModelProperty(value = "更新时间")
    private Date updatedTime;
    
    /**
     * 简历状态0：未删除 1：已删除
     */
    @ApiModelProperty(value = "简历状态0-待审核 1-已发布 2-已删除")
    private Integer status;

}
