package com.irum.teamup.query;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;


@Data
@EqualsAndHashCode(callSuper = true)
@ApiModel(description = "用户分页查询条件")
public class UserPageQuery extends PageQuery {


    /**
     * 用户名
     */
    @ApiModelProperty("用户名")
    private String username;


    /**
     * 学号
     */
    @ApiModelProperty("学号")
    private String sid;


    /**
     * 学院
     */
    @ApiModelProperty("学院")
    private String college;


    /**
     * 专业
     */
    @ApiModelProperty("专业")
    private String major;


    /**
     * 账号状态：0-正常，1-已删除/禁用
     */
    @ApiModelProperty("账号状态")
    private Integer status;


}
