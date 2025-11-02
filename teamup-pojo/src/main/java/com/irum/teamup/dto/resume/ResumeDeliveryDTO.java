package com.irum.teamup.dto.resume;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@ApiModel("简历投递DTO")
public class ResumeDeliveryDTO {

    /**
     * 主键ID
     */
    @ApiModelProperty("主键ID")
    private Long id;

    /**
     * 项目ID
     */
    @ApiModelProperty(value = "项目ID", required = true)
    private Long projectId;

    /**
     * 申请人ID
     */
    @ApiModelProperty(value = "申请人ID", required = true)
    private Long applicantId;

    /**
     * 简历内容
     */
    @ApiModelProperty("简历内容")
    private String resumeContent;

    /**
     * 状态：APPLIED-已投递, VIEWED-已查看, ACCEPTED-已录取, REJECTED-已拒绝
     */
    @ApiModelProperty("状态：APPLIED-已投递, VIEWED-已查看, ACCEPTED-已录取, REJECTED-已拒绝")
    private String status;

    /**
     * 投递时间
     */
    @ApiModelProperty("投递时间")
    private LocalDateTime deliveryTime;

    /**
     * 查看时间
     */
    @ApiModelProperty("查看时间")
    private LocalDateTime viewedTime;

    /**
     * 处理时间
     */
    @ApiModelProperty("处理时间")
    private LocalDateTime processedTime;

    /**
     * 备注
     */
    @ApiModelProperty("备注")
    private String notes;
}
