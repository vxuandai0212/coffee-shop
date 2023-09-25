package com.shop.coffee.response;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Builder
public class OrderDetailResponse {
  private Long id;
  private String name;
  private String category;
  private int quantity;
  private BigDecimal pricePerItem;
  private BigDecimal totalItemPrice;
}
