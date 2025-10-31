package com.irum.teamup.enums.Project;

import lombok.Getter;

@Getter
public enum ProjectStatus {

    PENDING(0),
    APPROVED(1),
    REJECTED(2),
    COMPLETED(4),
    DELETED(5);

    ProjectStatus(Integer code) {
        this.code = code;
    }

    private final Integer code;

    public Integer getCode() {
        return code;
    }
}
