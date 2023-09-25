package com.shop.coffee.bean;

import com.shop.coffee.enums.OrderStatusEnum;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.sql.Timestamp;

@Data
@Builder
public class OrderBean {
  private String customerName;
  private Long queueId;
  private OrderStatusEnum status;
  private Long createdAt;
  private Long updatedAt;
  private String itemName;
  private String itemCategory;
  private int itemQuantity;
  private BigDecimal itemPrice;
  private Long orderId;
  private Long orderDetailId;

  public static OrderBean mapPropertyFromList(Object[] input) {
    return OrderBean.builder()
            .itemQuantity((Short) (input[0]))
            .customerName((String) input[1])
            .queueId(((Integer) input[2]).longValue())
            .createdAt(((Timestamp) input[3]).getTime())
            .updatedAt(((Timestamp) input[4]).getTime())
            .status(OrderStatusEnum.of((String) input[5]))
            .itemPrice((BigDecimal) input[6])
            .itemCategory((String) input[7])
            .itemName((String) input[8])
            .orderId(((Integer) input[9]).longValue())
            .orderDetailId(((Integer) input[10]).longValue())
            .build();
  }
}
