package com.irum.teamup.convention.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;


@AllArgsConstructor
@Getter
public class BaseException extends RuntimeException {
    Integer code;
    String message;
}
