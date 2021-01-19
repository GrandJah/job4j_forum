package ru.job4j.forum.model;

import java.util.Calendar;
import lombok.Data;

@Data
public class Post {
  private Integer id;
  private String name;
  private String desc;
  private Calendar created;

  public static Post of(String name, String desc) {
    Post post = new Post();
    post.name = name;
    post.desc = desc;
    return post;
  }
}
