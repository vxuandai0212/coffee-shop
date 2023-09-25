package com.shop.coffee.pojo;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;

@Entity
@Table(name = "shop_item")
@Data
public class ShopItem {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private Long itemId;
  private BigDecimal price;
  private Long shopId;
}
