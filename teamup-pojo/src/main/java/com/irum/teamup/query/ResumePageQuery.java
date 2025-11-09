package com.irum.teamup.query;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
@ApiModel(description = "简历分页查询条件")
public class ResumePageQuery extends PageQuery {




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
     * 简历状态0-待审核 1-已发布 2-已删除
     */
    @ApiModelProperty(value = "简历状态0-待审核 1-已发布 2-已删除")
    private Integer status;




}
