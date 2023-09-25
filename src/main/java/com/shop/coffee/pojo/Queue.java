package com.shop.coffee.pojo;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "queues")
@Data
public class Queue {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private int maxSize;
  private Long shopId;
}
