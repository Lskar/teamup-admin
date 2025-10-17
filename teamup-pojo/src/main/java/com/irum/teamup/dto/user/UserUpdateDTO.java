package com.irum.teamup.dto.user;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel("用户更新DTO")
public class UserUpdateDTO {


    /**
     * 用户ID
     */
    @ApiModelProperty(value = "用户ID")
    private Long id;

    /**
     * 用户名
     */
    @ApiModelProperty(value = "用户名")
    private String username;


    /**
     * 密码
     */
    @ApiModelProperty(value = "密码")
    private String password;


    /**
     * 邮箱
     */
    @ApiModelProperty(value = "邮箱")
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
    private String sid; // 学号


    /**
     * 学院
     */
    @ApiModelProperty(value = "学院")
    private String college; // 学院


    /**
     * 专业
     */
    @ApiModelProperty(value = "专业")
    private String major; // 专业


}
