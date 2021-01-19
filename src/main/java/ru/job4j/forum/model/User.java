package ru.job4j.forum.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(of = "id")
public class User {
  private Integer id;

  private String password;

  private String username;
}
