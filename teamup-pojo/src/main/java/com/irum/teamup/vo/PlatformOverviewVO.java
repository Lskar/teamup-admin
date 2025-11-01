package com.irum.teamup.vo;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(description = "平台运营数据概览VO")
public class PlatformOverviewVO {


    /**
     * 用户总数量
     */
    @ApiModelProperty(value = "用户总数量")
    private Long totalUsers;


    /**
     * 项目总数量
     */
    @ApiModelProperty(value = "项目总数量")
    private Long totalProjects;


    /**
     * 简历投递总数量
     */
    @ApiModelProperty(value = "简历投递总数量")
    private Long totalResumeDeliveries;


    /**
     * 今日活跃用户数量
     */
    @ApiModelProperty(value = "今日活跃用户数量")
    private Long activeUsersToday;


    /**
     * 总用户数增长率
     */
    @ApiModelProperty(value = "总用户数增长率")
    // 增长率
    private Double growthRate;


}
