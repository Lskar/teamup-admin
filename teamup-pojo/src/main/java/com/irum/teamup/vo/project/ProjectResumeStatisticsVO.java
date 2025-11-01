// ProjectResumeStatisticsVO.java
package com.irum.teamup.vo.project;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(description = "项目简历投递统计VO")
public class ProjectResumeStatisticsVO {
    
    @ApiModelProperty(value = "项目ID")
    private Long projectId;
    
    @ApiModelProperty(value = "简历投递数量")
    private Integer resumeCount;
}
