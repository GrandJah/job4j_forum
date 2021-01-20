package ru.job4j.forum.model;

import java.util.Calendar;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "posts")
public class Post {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  private String name;

  @Column(name = "description")
  private String desc;

  private Calendar created = Calendar.getInstance();

  public static Post of(String name, String desc) {
    Post post = new Post();
    post.name = name;
    post.desc = desc;
    return post;
  }
}
