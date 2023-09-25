package com.shop.coffee.enums;

import com.shop.coffee.exception.AppException;
import com.shop.coffee.exception.AppMessage;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.experimental.FieldDefaults;

@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public enum OrderStatusEnum {
  WAITING("WAITING"),
  PREPARING("PREPARING"),
  CANCEL("CANCEL"),
  DONE("DONE");

  String status;

  public static OrderStatusEnum of(String status) {
    try {
      return OrderStatusEnum.valueOf(status.toUpperCase());
    } catch (IllegalArgumentException exception) {
      throw new AppException.BadRequestResponse(AppMessage.INVALID_ORDER_STATUS);
    }
  }
}
