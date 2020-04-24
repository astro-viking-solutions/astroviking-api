package com.astroviking.api.controllers;

import com.astroviking.api.domain.Health;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/healthcheck")
public class HealthController {

  @GetMapping
  public Health getHealth() {
    return new Health();
  }
}
