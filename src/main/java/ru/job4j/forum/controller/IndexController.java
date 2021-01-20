package ru.job4j.forum.controller;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import ru.job4j.forum.service.PostService;

@Controller
public class IndexController {
  private final PostService posts;

  public IndexController(PostService posts) {
    this.posts = posts;
  }

  @GetMapping({"/", "/index"})
  public String index(Model model) {
    model.addAttribute("user", SecurityContextHolder.getContext()
                                                    .getAuthentication()
                                                    .getPrincipal());
    model.addAttribute("posts", posts.getAll());
    return "index";
  }
}
