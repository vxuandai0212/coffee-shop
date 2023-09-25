package com.shop.coffee.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum AppMessage {
  INVALID_USER_ROLE("ER-0001", "User's role is not valid"),
  INVALID_ORDER_STATUS("ER-0002", "Order's status is not valid");

  public final String msgCode;
  public final String message;
}
