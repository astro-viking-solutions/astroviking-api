package com.astroviking.api.controllers;

import com.astroviking.api.models.ConnectRequest;
import com.astroviking.api.services.EmailService;
import io.swagger.annotations.ApiOperation;
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
  @ResponseStatus(HttpStatus.CREATED)
  @ApiOperation(value = "Submit a connection request.")
  public void connect(@RequestBody @Valid ConnectRequest connectRequest) {
    emailService.sendEmail(connectRequest);
  }
}
