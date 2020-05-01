package com.astroviking.api.controllers;

import com.astroviking.api.dto.ConnectDto;
import com.astroviking.api.services.ConnectService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/connect")
public class ConnectController {

  private final ConnectService connectService;

  public ConnectController(ConnectService connectService) {
    this.connectService = connectService;
  }

  @PostMapping
  public void connect(@RequestBody ConnectDto connectDto) {}
}
