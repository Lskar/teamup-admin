package com.irum.teamup.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description = "学院项目统计")
public class CollegeProjectStatsVO {


    /**
     * 学院名称
     */
    @ApiModelProperty(value = "学院名称")
    private String college;


    /**
     * 项目数量
     */
    @ApiModelProperty(value = "项目数量")
    private Long projectCount;


    /**
     * 用户数量
     */
    @ApiModelProperty(value = "用户数量")
    private Long userCount;
}
