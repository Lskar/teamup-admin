package com.irum.teamup.query;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.sql.Date;

@Data
@EqualsAndHashCode(callSuper = true)
public class ResumeDeliveryPageQuery extends PageQuery{

    private Long id;

    private Long applicantId;

    private Integer status;

    private Date deliveryTime;

    private Date viewedTime;

    private Date processedTime;

}
