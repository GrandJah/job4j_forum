package ru.job4j.forum.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import ru.job4j.forum.model.User;
import ru.job4j.forum.repository.UserRepository;

@Controller
public class RegController {

  private final UserRepository users;

  public RegController(UserRepository users) {
    this.users = users;
  }

  @PostMapping("/reg")
  public String save(@ModelAttribute User user) {
    return "redirect:/login";
  }

  @GetMapping("/reg")
  public String reg() {
    return "reg";
  }
}
