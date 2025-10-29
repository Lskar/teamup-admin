package com.irum.teamup.enums;

import com.irum.teamup.convention.errorcode.IErrorCode;

public enum UserErrorCodeEnum implements IErrorCode {





    USER_NOT_FOUND("USER_001", "用户不存在"),

    USER_EXIST("USER_002", "用户已存在"),

    USER_CREATE_FAILED("USER_003", "用户创建失败"),

    USER_UPDATE_FAILED("USER_004", "用户更新失败"),

    USER_DELETE_FAILED("USER_005", "用户删除失败"),

    USER_LOGIN_FAILED("USER_006", "用户登录失败"),

    USER_LOGOUT_FAILED("USER_007", "用户登出失败"),

    USER_LOGIN_EXPIRED("USER_008", "用户登录已过期");



    private final String code;
    private final String message;
    UserErrorCodeEnum(String code, String message) {
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
