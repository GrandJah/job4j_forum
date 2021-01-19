package ru.job4j.forum.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import ru.job4j.forum.model.Post;
import ru.job4j.forum.service.PostService;

@Controller
public class PostController {
  private final PostService posts;

  public PostController(PostService posts) {
    this.posts = posts;
  }

  @GetMapping("/post")
  public String post(Model model, @RequestParam(required = false) Integer id) {
    model.addAttribute("post", posts.findById(id));
    return "post";
  }

  @GetMapping("/edit")
  public String edit(Model model, @RequestParam(required = false) Integer id) {
    if (id != null) {
      Post post = posts.findById(id);
      if (post != null) {
        model.addAttribute("post", posts.findById(id));
      }
    }
    return "edit";
  }

  @PostMapping("/save")
  public String edit(Model model, @ModelAttribute Post post) {
    posts.save(post);
    return "redirect:/";
  }
}
