package com.shop.coffee.service;

import com.shop.coffee.bean.OrderBean;
import com.shop.coffee.repository.OrderRepository;
import com.shop.coffee.response.OrderDetailResponse;
import com.shop.coffee.response.OrderListResponse;
import com.shop.coffee.response.OrderResponse;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class OrderService {
  @Autowired
  private OrderRepository orderRepository;

  @PersistenceContext
  private EntityManager entityManager;

  public OrderListResponse getOrderList() {
    var total = orderRepository.count();
    var objectList = orderRepository.getOrderList(entityManager);
    var orderBeanList = objectList.stream().map(e -> OrderBean.mapPropertyFromList(e)).toList();
    Map<Long, List<OrderBean>> map = orderBeanList.stream().collect(Collectors.groupingBy(OrderBean::getOrderId));
    List<OrderResponse> items = new ArrayList<>();
    for (Long orderId : map.keySet()) {
      List<OrderBean> orderBeans = map.get(orderId);
      List<OrderDetailResponse> details = orderBeans.stream().map(i ->
        OrderDetailResponse.builder()
          .id(i.getOrderDetailId())
          .name(i.getItemName())
          .category(i.getItemCategory())
          .quantity(i.getItemQuantity())
          .pricePerItem(i.getItemPrice())
          .totalItemPrice(i.getItemPrice().multiply(BigDecimal.valueOf(i.getItemQuantity())))
          .build()).collect(Collectors.toList());
      BigDecimal totalPrice = details.stream()
        .map(OrderDetailResponse::getTotalItemPrice)
        .reduce(BigDecimal.ZERO, BigDecimal::add);
      OrderResponse item = OrderResponse.builder()
              .id(orderId)
              .customerName(orderBeans.get(0).getCustomerName())
              .details(details)
              .totalPrice(totalPrice)
              .queueId(orderBeans.get(0).getQueueId())
              .status(orderBeans.get(0).getStatus())
              .createdAt(orderBeans.get(0).getCreatedAt())
              .updatedAt(orderBeans.get(0).getUpdatedAt())
              .build();
      items.add(item);
    }

    return OrderListResponse.builder()
            .items(items)
            .total(total)
            .build();
  }
}
