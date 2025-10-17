package com.irum.teamup.dto.project;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 项目更新DTO
 */
@Data
@ApiModel("项目更新DTO")
public class ProjectUpdateDTO {

    /**
     * 项目ID，主键自增
     */

    @ApiModelProperty(value = "项目ID")
    private Long id;

    /**
     * 项目标题，不能为空
     */
    @ApiModelProperty(value = "项目标题")
    private String title;

    /**
     * 项目描述
     */
    @ApiModelProperty(value = "项目描述")
    private String description;

    /**
     * 招募要求
     */
    @ApiModelProperty(value = "招募要求")
    private String requirements;

    /**
     * 项目类型
     */
    @ApiModelProperty(value = "项目类型")
    private String projectType;

    /**
     * 所属学院
     */
    @ApiModelProperty(value = "所属学院")
    private String college;

    /**
     * 相关专业
     */
    @ApiModelProperty(value = "相关专业")
    private String major;

    /**
     * 项目状态：PENDING-待审核, PUBLISHED-已发布, FULL-已满员, ENDED-已结束
     */
    @ApiModelProperty(value = "项目状态")
    private String status;

    /**
     * 创建者ID，不能为空
     */
    @ApiModelProperty(value = "创建者ID")
    private Long creatorId;

    /**
     * 团队规模，默认值为1
     */
    @ApiModelProperty(value = "团队规模")
    private Integer teamSize;

    /**
     * 当前成员数，默认值为1
     */
    @ApiModelProperty(value = "当前成员数")
    private Integer currentMembers;

}
