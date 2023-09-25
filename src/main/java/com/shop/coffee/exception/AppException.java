package com.shop.coffee.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;

import java.util.Map;

@Getter
public class AppException extends RuntimeException {

  private static final String MESSAGE = "message";
  private static final String CODE = "msgCode";
  public final HttpStatus status;
  public final Map<String, String> details;

  public AppException(final HttpStatus status, final Map<String, String> details) {
    this.status = status;
    this.details = details;
  }

  public AppException(final HttpStatus status, final String details) {
    this(status, Map.of("details", details));
  }


  @Override
  public String toString() {
    return "AppException{" +
            "status=" + status +
            ", details=" + details +
            '}';
  }

  public static final class BadRequestResponse extends AppException {

    public BadRequestResponse(final Map<String, String> details) {
      super(HttpStatus.BAD_REQUEST, details);
    }

    public BadRequestResponse(final String message) {
      this(Map.of(MESSAGE, message));
    }

    public BadRequestResponse(final AppMessage msg) {
      this(Map.of(CODE, msg.msgCode, MESSAGE, msg.message));
    }

    public BadRequestResponse(String code, String msg) {
      this(Map.of(CODE, code, MESSAGE, msg));
    }

    public BadRequestResponse() {
      this(Map.of());
    }
  }

  public static final class UnauthorizedResponse extends AppException {

    public UnauthorizedResponse(final Map<String, String> details) {
      super(HttpStatus.UNAUTHORIZED, details);
    }

    public UnauthorizedResponse(final String message) {
      super(HttpStatus.UNAUTHORIZED, Map.of(MESSAGE, message));
    }

    public UnauthorizedResponse(final AppMessage msg) {
      this(Map.of(CODE, msg.msgCode, MESSAGE, msg.message));
    }

    public UnauthorizedResponse() {
      super(HttpStatus.UNAUTHORIZED, Map.of());
    }
  }


  public static final class InternalServerErrorResponse extends AppException {

    public InternalServerErrorResponse(final Map<String, String> details) {
      super(HttpStatus.INTERNAL_SERVER_ERROR, details);
    }

    public InternalServerErrorResponse(final String message) {
      super(HttpStatus.INTERNAL_SERVER_ERROR, Map.of(MESSAGE, message));
    }

    public InternalServerErrorResponse(final AppMessage msg) {
      this(Map.of(CODE, msg.msgCode, MESSAGE, msg.message));
    }

  }

  public static final class TimeOut504StatusCodeResponse extends AppException {

    public TimeOut504StatusCodeResponse(final String message) {
      super(HttpStatus.GATEWAY_TIMEOUT, message);
    }
  }

}

