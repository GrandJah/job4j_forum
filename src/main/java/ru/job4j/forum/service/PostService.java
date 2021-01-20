package ru.job4j.forum.service;

import org.springframework.stereotype.Service;

import ru.job4j.forum.model.Post;
import ru.job4j.forum.repository.PostRepository;

@Service
public class PostService {

  private final PostRepository posts;

  public PostService(PostRepository posts) {
    this.posts = posts;
  }

  public Iterable<Post> getAll() {
    return posts.findAll();
  }

  public Post findById(Integer id) {
    return posts.findById(id)
                .orElse(null);
  }

  public Post save(Post post) {
    Integer id = post.getId();
    if (id != null) {
      posts.findById(id)
           .ifPresent(value -> post.setCreated(value.getCreated()));
    }
    return posts.save(post);
  }
}
