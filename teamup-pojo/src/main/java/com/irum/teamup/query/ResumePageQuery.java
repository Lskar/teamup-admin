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
     * 简历标题
     */
    @ApiModelProperty("简历标题")
    private String resumeTitle;

    /**
     * 申请人ID
     */
    @ApiModelProperty("申请人ID")
    private Long applicantId;

    /**
     * 文件格式
     */
    @ApiModelProperty("文件格式")
    private String fileFormat;

    /**
     * 简历状态
     */
    @ApiModelProperty("简历状态")
    private Integer status;
}
