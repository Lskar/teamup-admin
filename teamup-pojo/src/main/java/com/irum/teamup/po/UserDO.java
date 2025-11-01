package com.irum.teamup.po;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;
import java.util.Date;

@Data
@TableName("user")
@NoArgsConstructor
@ApiModel(description = "用户信息DO")
public class UserDO {


    /**
     * id
     */
    @TableId(value = "id", type = IdType.AUTO)
    @ApiModelProperty(value = "id")
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


    /**
     * 创建时间
     */
    @ApiModelProperty(value = "创建时间")
    private Date createTime; // 创建时间


    /**
     * 账号状态
     */
    @ApiModelProperty(value = "账号状态")
    private Integer status; // 账号状态：0-正常，1-已删除/禁用


}
