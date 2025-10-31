package com.irum.teamup.vo.project;

import com.irum.teamup.vo.user.UserVO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;
import java.util.List;

/**
 * 项目信息VO
 */
@Data
@ApiModel(value = "项目信息VO")
public class ProjectVO {
    
    /**
     * 项目ID
     */
    @ApiModelProperty(value = "项目ID", required = true)
    private Long id;
    
    /**
     * 项目标题
     */
    @ApiModelProperty(value = "项目标题", required = true)
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
     * 状态：PENDING-待审核, PUBLISHED-已发布, FULL-已满员, ENDED-已结束
     */
    @ApiModelProperty(value = "项目状态")
    private Integer status;
    
    /**
     * 创建者ID
     */
    @ApiModelProperty(value = "创建者ID", required = true)
    private Long creatorId;
    
    /**
     * 团队规模
     */
    @ApiModelProperty(value = "团队规模")
    private Integer teamSize;
    
    /**
     * 当前成员数
     */
    @ApiModelProperty(value = "当前成员数")
    private Integer currentMembers;
    
    /**
     * 开始时间
     */
    @ApiModelProperty(value = "开始时间")
    private Date startTime;
    
    /**
     * 结束时间
     */
    @ApiModelProperty(value = "结束时间")
    private Date endTime;
    
    /**
     * 创建时间
     */
    @ApiModelProperty(value = "创建时间")
    private Date createdTime;
    
    /**
     * 更新时间
     */
    @ApiModelProperty(value = "更新时间")
    private Date updatedTime;


    /**
     * 项目成员信息
     */
    @ApiModelProperty(value = "项目成员信息")
    private List<UserVO> userVOList;

}
