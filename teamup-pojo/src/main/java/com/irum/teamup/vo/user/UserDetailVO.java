package com.irum.teamup.vo.user;

import java.time.LocalDateTime;

public class UserDetailVO {

    private Long id;

    private String username;


    private String password;


    private String mail;


    private String phone;


    private String sid; // 学号


    private String college; // 学院


    private String major; // 专业


    private LocalDateTime createTime; // 创建时间


    private Integer status; // 账号状态：0-正常，1-已删除/禁用



}
