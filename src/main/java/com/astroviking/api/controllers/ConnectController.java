package com.astroviking.api.controllers;

import com.astroviking.api.models.ConnectRequest;
import com.astroviking.api.services.EmailService;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping(ConnectController.BASE_URL)
public class ConnectController {

  public static final String BASE_URL = "/connect";
  private final EmailService emailService;

  public ConnectController(EmailService emailService) {
    this.emailService = emailService;
  }

  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  @ApiOperation("Submit a connection request.")
  public void connect(@RequestBody @Valid ConnectRequest connectRequest) {
    emailService.sendEmail(connectRequest);
  }
}
