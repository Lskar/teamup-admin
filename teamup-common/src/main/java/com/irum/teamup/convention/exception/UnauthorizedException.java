package com.irum.teamup.convention.exception;

import com.irum.teamup.convention.errorcode.BaseErrorCode;
import com.irum.teamup.convention.errorcode.IErrorCode;

public class UnauthorizedException extends AbstractException {
  public UnauthorizedException(String message) {
    this(message, null, BaseErrorCode.UNAUTHORIZED_ERROR);
  }

  public UnauthorizedException(String message, IErrorCode errorCode) {
    this(message, null, errorCode);
  }

  public UnauthorizedException(String message, Throwable throwable, IErrorCode errorCode) {
    super(message, throwable, errorCode);
  }

  @Override
  public String toString() {
    return "UnauthorizedException{" +
            "code='" + errorCode + "'," +
            "message='" + errorMessage + "'" +
            '}';
  }
}
