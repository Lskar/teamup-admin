package com.irum.teamup.enums;

import lombok.Getter;

/**
 * 项目相关错误码枚举
 */
@Getter
public enum ProjectErrorCodeEnum {
    
    /**
     * 项目不存在
     */
    PROJECT_NOT_FOUND("PROJECT_001", "项目不存在"),
    
    /**
     * 项目状态无效
     */
    INVALID_PROJECT_STATUS("PROJECT_002", "项目状态无效"),
    
    /**
     * 项目创建失败
     */
    PROJECT_CREATE_FAILED("PROJECT_003", "项目创建失败"),
    
    /**
     * 项目更新失败
     */
    PROJECT_UPDATE_FAILED("PROJECT_004", "项目更新失败"),
    
    /**
     * 项目删除失败
     */
    PROJECT_DELETE_FAILED("PROJECT_005", "项目删除失败");

    private final String code;
    private final String message;

    ProjectErrorCodeEnum(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public String message() {
        return message;
    }

    public String code() {
        return code;
    }
}
