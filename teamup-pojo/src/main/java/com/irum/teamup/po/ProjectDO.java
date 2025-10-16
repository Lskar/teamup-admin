package com.irum.teamup.po;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.Date;

@Data
@TableName("project")
public class ProjectDO {

    private Long id;

    private String title;

    private String description;

    private String requirements;

    private String projectType;

    private String college;

    private String major;

    private String status;

    private Long creatorId;

    private Integer teamSize;

    private Integer currentMembers;

    private Date startTime;

    private Date endTime;

    private Date createdTime;

    private Date updatedTime;

}
