package com.shop.coffee.pojo;

import com.shop.coffee.enums.UserRoleEnum;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "users")
@Data
public class User {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private String mobilePhone;
  @Transient
  private String password;
  private String name;
  private String homeAddress;
  private String workAddress;
  private UserRoleEnum role;
}
