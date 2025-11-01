package com.irum.teamup.convention.exception.system;

import com.irum.teamup.convention.errorcode.HttpStatusEnum;
import com.irum.teamup.convention.exception.BaseException;

public class UnauthorizedException extends BaseException {

    public UnauthorizedException(String message) {
        super(HttpStatusEnum.UNAUTHORIZED.getCode(), message);
    }
    public UnauthorizedException(){
        super(HttpStatusEnum.UNAUTHORIZED.getCode(), HttpStatusEnum.UNAUTHORIZED.getMessage());
    }
}
