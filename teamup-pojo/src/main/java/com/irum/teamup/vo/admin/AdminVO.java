package com.irum.teamup.vo.admin;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.irum.teamup.serialize.PhoneDesensitizationSerializer;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author irum
 * @date 2022/1/23
 **/
@Data
@ApiModel(value = "管理员信息VO")
public class AdminVO {

    /**
     * id
     */
    @ApiModelProperty(value = "用户id")
    private Long id;

    /**
     * 用户名
     */
    @ApiModelProperty(value = "用户名")
    private String username;


    /**
     * 真实姓名
     */
    @ApiModelProperty(value = "真实姓名")
    private String realName;

    /**
     * 手机号
     */
    @ApiModelProperty(value = "手机号")
    @JsonSerialize(using = PhoneDesensitizationSerializer.class)
    private String phone;

    /**
     * 邮箱
     */
    @ApiModelProperty(value = "邮箱")
    private String mail;

    /**
     * 注销时间戳
     */
    @ApiModelProperty(value = "注销时间戳")
    private Long deletionTime;
}
