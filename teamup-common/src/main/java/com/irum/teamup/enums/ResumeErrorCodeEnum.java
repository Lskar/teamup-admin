package com.irum.teamup.enums;

import lombok.Getter;

/**
 * 简历相关错误码枚举
 */
@Getter
public enum ResumeErrorCodeEnum {
    
    /**
     * 简历不存在
     */
    RESUME_NOT_FOUND("RESUME_001", "简历不存在"),
    
    /**
     * 简历状态无效
     */
    INVALID_RESUME_STATUS("RESUME_002", "简历状态无效"),
    
    /**
     * 简历创建失败
     */
    RESUME_CREATE_FAILED("RESUME_003", "简历创建失败"),
    
    /**
     * 简历更新失败
     */
    RESUME_UPDATE_FAILED("RESUME_004", "简历更新失败"),
    
    /**
     * 简历删除失败
     */
    RESUME_DELETE_FAILED("RESUME_005", "简历删除失败"),
    
    /**
     * 简历导出失败
     */
    RESUME_EXPORT_FAILED("RESUME_006", "简历导出失败");

    private final String code;
    private final String message;

    ResumeErrorCodeEnum(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public String code() {
        return code;
    }

    public String message() {
        return message;
    }
}
