package com.irum.teamup.convention.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;


@AllArgsConstructor
@Getter
public class BaseException extends RuntimeException {
    String code;
    String message;
}
