package com.irum.teamup.query;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.format.annotation.DateTimeFormat;

import java.sql.Date;

@Data
@EqualsAndHashCode(callSuper = true)
public class ResumeDeliveryPageQuery extends PageQuery{

    private Long id;

    private Long applicantId;

    private Integer status;


    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private String deliveryTime;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private String viewedTime;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private String processedTime;

}
