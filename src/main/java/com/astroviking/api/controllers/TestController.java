package com.astroviking.api.controllers;

import com.astroviking.api.domain.TestModel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(TestController.BASE_URL)
public class TestController {

  public static final String BASE_URL = "/test";

  @GetMapping
  public TestModel getTest() {
    return new TestModel();
  }
}
