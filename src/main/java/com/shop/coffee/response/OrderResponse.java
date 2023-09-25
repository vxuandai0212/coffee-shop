package com.shop.coffee.response;

import com.shop.coffee.enums.OrderStatusEnum;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

@Data
@Builder
public class OrderResponse {
  private Long id;
  private String customerName;
  private List<OrderDetailResponse> details;
  private BigDecimal totalPrice;
  private Long queueId;
  private OrderStatusEnum status;
  private Long createdAt;
  private Long updatedAt;
}
