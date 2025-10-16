package com.irum.teamup.enums;

import com.irum.teamup.convention.errorcode.IErrorCode;

public enum AdminErrorCodeEnum implements IErrorCode {

    USER_NULL("B000200", "用户不存在"),
    USER_NAME_EXIST("B000201", "用户名已存在"),
    USER_EXIST("B000202", "用户已存在"),
    USER_SAVE_ERROR("B000203", "用户保存失败");


    private final String code;

    private final String message;

    AdminErrorCodeEnum(String code, String message) {
        this.code = code;
        this.message = message;
    }

    @Override
    public String code() {
        return code;
    }

    @Override
    public String message() {
        return message;
    }
}
