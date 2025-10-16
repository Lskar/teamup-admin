package com.irum.teamup.po;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@TableName("user")
public class UserDO {


    /**
     * id
     */
    @TableId(value = "id", type = IdType.AUTO)
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
