package com.shop.coffee.pojo;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "order_detail")
@Data
public class OrderDetail {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private Long shopItemId;
  private int quantity;
  private Long orderId;
}
