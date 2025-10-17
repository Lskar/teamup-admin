package com.irum.teamup.vo.admin;


import io.swagger.annotations.ApiModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ApiModel("用户登录返回参数")
public class AdminLoginVO {
    /**
     * 登录token
     */
    private String token;

}
