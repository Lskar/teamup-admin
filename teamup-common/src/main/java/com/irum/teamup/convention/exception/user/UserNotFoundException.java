package com.irum.teamup.convention.exception.user;

import com.irum.teamup.convention.exception.BaseException;
import com.irum.teamup.enums.UserErrorCodeEnum;

public class UserNotFoundException extends BaseException {
    public UserNotFoundException(String code, String message) {
        super(code, message);
    }
}
