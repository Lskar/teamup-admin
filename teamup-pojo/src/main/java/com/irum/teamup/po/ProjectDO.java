package com.irum.teamup.po;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

/**
 * 项目信息DO
 */
@Data
@TableName("project")
@ApiModel(description = "项目信息DO")
public class ProjectDO {

    /**
     * 项目ID，主键自增
     */
    @TableId(type = IdType.AUTO)
    @ApiModelProperty(value = "项目ID，主键自增")
    private Long id;

    /**
     * 项目标题，不能为空
     */

    @ApiModelProperty(value = "项目标题，不能为空")
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

    @ApiModelProperty(value = "项目状态：PENDING-待审核, PUBLISHED-已发布, FULL-已满员, ENDED-已结束")
    private Integer status;

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

    /**
     * 项目开始时间
     */

    @ApiModelProperty(value = "项目开始时间")
    private Date startTime;

    /**
     * 项目结束时间
     */

    @ApiModelProperty(value = "项目结束时间")
    private Date endTime;

    /**
     * 创建时间，默认当前时间
     */

    @ApiModelProperty(value = "创建时间")
    private Date createTime;

    /**
     * 更新时间，默认当前时间，更新时自动刷新
     */

    @ApiModelProperty(value = "更新时间")
    private Date updatedTime;

}
