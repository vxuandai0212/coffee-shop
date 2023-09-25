package com.shop.coffee.response;

import com.shop.coffee.bean.OrderBean;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class OrderListResponse {
  private List<OrderResponse> items;
  private Long total;
}
