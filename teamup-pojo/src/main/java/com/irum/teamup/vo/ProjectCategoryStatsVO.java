package com.irum.teamup.vo;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(value = "项目类别统计信息VO")
public class ProjectCategoryStatsVO {


    /**
     * 项目类别
     */
    @ApiModelProperty(value = "项目类别")
    private String category;


    /**
     * 项目数量
     */
    @ApiModelProperty(value = "项目数量")
    private Long count;

    /**
     * 项目占比
     */
    @ApiModelProperty(value = "项目占比")
    private Double percentage;
}
