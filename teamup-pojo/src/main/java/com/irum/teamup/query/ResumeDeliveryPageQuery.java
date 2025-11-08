package com.irum.teamup.query;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.format.annotation.DateTimeFormat;



@Data
@ApiModel(description = "简历投递分页查询条件")
@EqualsAndHashCode(callSuper = true)
public class ResumeDeliveryPageQuery extends PageQuery{

    @ApiModelProperty("主键ID，项目id")
    private Long id;

    @ApiModelProperty("申请人，用户ID")
    private Long applicantId;

    @ApiModelProperty("简历状态")
    private Integer status;


}
