package com.irum.teamup.admin.dto.resp;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.irum.teamup.admin.common.serialize.PhoneDesensitizationSerializer;
import lombok.Data;

/**
 * @author irum
 * @date 2022/1/23
 **/
@Data
public class UserRespDTO {

    /**
     * id
     */
    private Long id;

    /**
     * 用户名
     */
    private String username;


    /**
     * 真实姓名
     */
    private String realName;

    /**
     * 手机号
     */
    @JsonSerialize(using = PhoneDesensitizationSerializer.class)
    private String phone;

    /**
     * 邮箱
     */
    private String mail;

    /**
     * 注销时间戳
     */
    private Long deletionTime;
}
