package com.skillnest.m6.seguridad.controller;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AppController {

  @GetMapping("/")
  public String home() {
    return "index";
  }

  @GetMapping("/login")
  public String login() {
    return "login";
  }

  @GetMapping("/panel")
  public String panel(Authentication auth, Model model) {
    if (auth != null) {
      model.addAttribute("usuario", auth.getName());
      model.addAttribute("roles", auth.getAuthorities());
    }
    return "panel";
  }

  @GetMapping("/perfil")
  public String perfil(Authentication auth, Model model) {
    if (auth != null) {
      model.addAttribute("usuario", auth.getName());
      model.addAttribute("roles", auth.getAuthorities());
    }
    return "perfil";
  }

  @GetMapping("/admin")
  public String admin(Authentication auth, Model model) {
    if (auth != null) {
      model.addAttribute("usuario", auth.getName());
      model.addAttribute("roles", auth.getAuthorities());
    }
    return "admin";
  }
}
