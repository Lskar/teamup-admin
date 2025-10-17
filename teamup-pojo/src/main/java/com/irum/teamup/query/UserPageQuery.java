package com.irum.teamup.query;

import lombok.Data;
import lombok.EqualsAndHashCode;


@Data
@EqualsAndHashCode(callSuper = true)
public class UserPageQuery extends PageQuery {


    private String username;



    private String sid;



    private String college;



    private String major;


    private Integer status;


}
