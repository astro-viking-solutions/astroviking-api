package com.astroviking.api.controllers;

import com.astroviking.api.dto.ConnectRequest;
import com.astroviking.api.services.EmailService;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.validation.Valid;

@Controller
@RequestMapping(ConnectController.BASE_URL)
public class ConnectController {

  public static final String BASE_URL = "/connect";
  private final EmailService emailService;

  public ConnectController(EmailService emailService) {
    this.emailService = emailService;
  }

  @PostMapping
  @ResponseStatus(HttpStatus.ACCEPTED)
  public void connect(@RequestBody @Valid ConnectRequest connectRequest) {
    emailService.sendEmail(connectRequest);
  }
}
