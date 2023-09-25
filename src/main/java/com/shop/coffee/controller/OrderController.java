package com.shop.coffee.controller;

import com.shop.coffee.response.OrderListResponse;
import com.shop.coffee.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderController {
  @Autowired
  private OrderService orderService;

  @GetMapping("/orders")
  OrderListResponse getAllOrder() {
    return orderService.getOrderList();
  }
}
