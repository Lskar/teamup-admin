package com.irum.teamup.vo.user;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@ApiModel(description = "用户详情VO")
public class UserDetailVO {

    /**
     * id
     */
    @ApiModelProperty(value = "用户id")
    private Long id;


    @ApiModelProperty(value = "用户名")
    private String username;


    @ApiModelProperty(value = "密码")
    private String password;


    @ApiModelProperty(value = "邮箱")
    private String mail;


    @ApiModelProperty(value = "手机号")
    private String phone;


    @ApiModelProperty(value = "学号")
    private String sid; // 学号


    @ApiModelProperty(value = "学院")
    private String college; // 学院


    @ApiModelProperty(value = "专业")
    private String major; // 专业


    @ApiModelProperty(value = "创建时间")
    private LocalDateTime createTime; // 创建时间


    @ApiModelProperty(value = "账号状态：0-正常，1-已删除/禁用")
    private Integer status; // 账号状态：0-正常，1-已删除/禁用



}
