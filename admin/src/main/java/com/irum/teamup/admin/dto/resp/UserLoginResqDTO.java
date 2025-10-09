package com.irum.teamup.admin.dto.resp;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserLoginResqDTO {
    /**
     * 登录token
     */
    private String token;

}
