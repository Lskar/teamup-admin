package com.irum.teamup.po;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.w3c.dom.Text;

import java.sql.Date;

@Data
@EqualsAndHashCode(callSuper = false)
@TableName("resume_delivery")
public class ResumeDeliveryDO {

    /**
     * 主键ID
     */
    @TableId(type = IdType.AUTO)
    private Long id;

    private Long projectId;

    private Long applicantId;

    private Text resumeContent;

    private Integer status;


    private Date deliveryTime;


    private Date viewedTime;


    private Date processedTime;


    private Text notes;

}
