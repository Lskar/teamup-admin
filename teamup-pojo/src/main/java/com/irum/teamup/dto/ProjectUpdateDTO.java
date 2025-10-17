package com.irum.teamup.dto;

import lombok.Data;

/**
 * 项目更新DTO
 */
@Data
public class ProjectUpdateDTO {

    /**
     * 项目ID，主键自增
     */
    private Long id;

    /**
     * 项目标题，不能为空
     */
    private String title;

    /**
     * 项目描述
     */
    private String description;

    /**
     * 招募要求
     */
    private String requirements;

    /**
     * 项目类型
     */
    private String projectType;

    /**
     * 所属学院
     */
    private String college;

    /**
     * 相关专业
     */
    private String major;

    /**
     * 项目状态：PENDING-待审核, PUBLISHED-已发布, FULL-已满员, ENDED-已结束
     */
    private String status;

    /**
     * 创建者ID，不能为空
     */
    private Long creatorId;

    /**
     * 团队规模，默认值为1
     */
    private Integer teamSize;

    /**
     * 当前成员数，默认值为1
     */
    private Integer currentMembers;

}
