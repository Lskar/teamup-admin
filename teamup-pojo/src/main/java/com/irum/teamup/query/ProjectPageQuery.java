package com.irum.teamup.query;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;


@Data
@EqualsAndHashCode(callSuper = true)
@ApiModel(description = "项目分页查询条件")
public class ProjectPageQuery extends PageQuery{


    /**
     * 项目标题，不能为空
     */
    @ApiModelProperty("项目标题")
    private String title;

    /**
     * 项目类型
     */
    @ApiModelProperty("项目类型")
    private String projectType;

    /**
     * 所属学院
     */
    @ApiModelProperty("所属学院")
    private String college;

    /**
     * 相关专业
     */
    @ApiModelProperty("相关专业")
    private String major;

    /**
     * 项目状态：PENDING-待审核, PUBLISHED-已发布, FULL-已满员, ENDED-已结束
     */
    @ApiModelProperty("项目状态")
    private Integer status;

    /**
     * 创建者ID，不能为空
     */
    @ApiModelProperty("创建者ID")
    private Long creatorId;

    /**
     * 团队规模，默认值为1
     */
    @ApiModelProperty("团队规模")
    private Integer teamSize;

    /**
     * 当前成员数，默认值为1
     */
    @ApiModelProperty("当前成员数")
    private Integer currentMembers;

    /**
     * 项目开始时间
     */

    @ApiModelProperty("项目开始时间")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private String startTime;

    /**
     * 项目结束时间
     */
    @ApiModelProperty("项目结束时间")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private String endTime;

}
