package ru.job4j.forum.service;

import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import ru.job4j.forum.model.Post;

@Service
public class PostService {

  private static int sequence = 1;
  private final Map<Integer, Post> posts = new HashMap<>();

  public PostService() {
    save(Post.of("Продаю машину ладу 01.", "Не бита, не крашена, у бабушки в гараже стояла."));
  }

  public Iterable<Post> getAll() {
    return posts.values();
  }

  public Post findById(Integer id) {
    return posts.get(id);
  }

  public void save(Post post) {
    if (post.getId() == null) {
      post.setId(sequence++);
    }
    posts.put(post.getId(), post);
  }
}
