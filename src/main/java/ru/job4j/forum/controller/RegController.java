package ru.job4j.forum.controller;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import ru.job4j.forum.model.User;
import ru.job4j.forum.repository.AuthorityRepository;
import ru.job4j.forum.repository.UserRepository;

@Controller
public class RegController {

  private final UserRepository users;

  private final PasswordEncoder encoder;

  private final AuthorityRepository authorities;

  public RegController(UserRepository users, PasswordEncoder encoder,
    AuthorityRepository authorities) {
    this.users = users;
    this.encoder = encoder;
    this.authorities = authorities;
  }

  @PostMapping("/reg")
  public String save(@ModelAttribute User user) {
    user.setEnabled(true);
    user.setPassword(encoder.encode(user.getPassword()));
    user.setAuthority(authorities.findByAuthority("ROLE_USER"));
    users.save(user);
    return "redirect:/login";
  }

  @GetMapping("/reg")
  public String reg() {
    return "reg";
  }
}
