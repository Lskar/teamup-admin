package com.irum.teamup.po;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@TableName("resume_delivery")
public class ResumeDeliveryDO {

    @TableId(type = IdType.AUTO)
    private Long id;

    @TableField("project_id")
    private Long projectId;

    @TableField("applicant_id")
    private Long applicantId;

    @TableField("resume_content")
    private String resumeContent;

    private Integer status;

    @TableField("delivery_time")
    private LocalDateTime deliveryTime;

    @TableField("viewed_time")
    private LocalDateTime viewedTime;

    @TableField("processed_time")
    private LocalDateTime processedTime;

    private String notes;

}