package com.shop.coffee.pojo;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "shops")
@Data
public class Shop {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private String location;
  private String contact;
  private String openTime;
  private String closeTime;
}
