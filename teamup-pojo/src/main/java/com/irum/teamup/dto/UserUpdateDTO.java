package com.irum.teamup.dto;

import lombok.Data;

@Data
public class UserUpdateDTO {


    private Long id;

    private String username;


    private String password;


    private String mail;


    private String phone;


    private String sid; // 学号


    private String college; // 学院


    private String major; // 专业


}
