package com.irum.teamup.vo;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@ApiModel(description = "平台运营数据概览VO")
@AllArgsConstructor
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
     * 总用户数增长率
     */
    @ApiModelProperty(value = "总用户数增长率")
    // 增长率
    private Double growthRate;

    /**
     * 今日新增项目数
     */
    @ApiModelProperty(value = "今日新增项目数")
    private Long newProjects;

}
