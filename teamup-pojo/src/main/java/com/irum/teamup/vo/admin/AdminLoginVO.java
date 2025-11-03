package com.irum.teamup.vo.admin;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ApiModel("管理员登录返回参数")
public class AdminLoginVO {


    /**
     * 管理员ID
     */
    @ApiModelProperty(value = "管理员ID")
    private Long userId;


    /**
     * 用户名
     */
    @ApiModelProperty(value = "管理员名称")
    private String username;


    /**
     * 登录token
     */
    @ApiModelProperty(value = "登录token")
    private String token;

}
