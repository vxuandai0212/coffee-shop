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
public enum UserRoleEnum {
  ADMIN("ADMIN"),
  OPERATOR("OPERATOR"),
  CUSTOMER("CUSTOMER");

  String role;

  public static UserRoleEnum of(String role) {
    try {
      return UserRoleEnum.valueOf(role.toUpperCase());
    } catch (IllegalArgumentException exception) {
      throw new AppException.BadRequestResponse(AppMessage.INVALID_USER_ROLE);
    }
  }
}
