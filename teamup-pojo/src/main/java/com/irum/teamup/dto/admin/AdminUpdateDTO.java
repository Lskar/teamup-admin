package com.irum.teamup.dto.admin;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel("用户更新参数")
public class AdminUpdateDTO {
    /**
     * 用户名
     */
    @ApiModelProperty(value = "用户名", required = true)
    private String username;

    /**
     * 密码
     */
    @ApiModelProperty(value = "密码", required = false)
    private String password;

    /**
     * 真实姓名
     */
    @ApiModelProperty(value = "真实姓名", required = false)
    private String realName;

    /**
     * 手机号
     */
    @ApiModelProperty(value = "手机号", required = false)
    private String phone;

    /**
     * 邮箱
     */
    @ApiModelProperty(value = "邮箱", required = false)
    private String mail;
}
