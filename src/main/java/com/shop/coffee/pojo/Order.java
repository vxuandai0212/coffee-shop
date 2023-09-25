package com.shop.coffee.pojo;

import com.shop.coffee.enums.OrderStatusEnum;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "orders")
@Data
public class Order {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private Long customerId;
  private Long queueId;
  private OrderStatusEnum status;
  private Long createdAt;
  private Long updatedAt;
}
