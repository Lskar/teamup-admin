package com.irum.teamup.vo.user;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;


@Data
@ApiModel(description = "用户信息VO")
public class UserVO {




    @ApiModelProperty(value = "用户id")
    private Long id;


    /**
     * 用户名
     */
    @ApiModelProperty(value = "用户名")
    private String username;

    /**
     * 邮箱
     */
    @ApiModelProperty(value = "用户邮箱")
    private String mail;

    /**
     * 手机号
     */
    @ApiModelProperty(value = "手机号")
    private String phone;

    /**
     * 学号
     */
    @ApiModelProperty(value = "学号")
    private String sid;

    /**
     * 学院
     */
    @ApiModelProperty(value = "学院")
    private String college;

    /**
     * 状态：0-正常，1-已删除/禁用
     */
    @ApiModelProperty(value = "用户状态")
    private Integer status;


}
