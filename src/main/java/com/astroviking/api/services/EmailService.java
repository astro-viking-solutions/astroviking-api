package com.astroviking.api.services;

import com.amazonaws.services.simpleemail.AmazonSimpleEmailService;
import com.amazonaws.services.simpleemail.model.*;
import com.astroviking.api.dto.ConnectRequest;
import org.springframework.stereotype.Service;

@Service
public class EmailService {

  public static final String EMAIL_ADDRESS = "tyler.gray@gmail.com";

  private final AmazonSimpleEmailService amazonSimpleEmailService;

  public EmailService(AmazonSimpleEmailService amazonSimpleEmailService) {
    this.amazonSimpleEmailService = amazonSimpleEmailService;
  }

  public void sendEmail(ConnectRequest connectRequest) {

    Destination destination = new Destination().withToAddresses(EMAIL_ADDRESS);
    Message message =
        new Message()
            .withSubject(
                new Content()
                    .withCharset("UTF-8")
                    .withData("Astro Viking Solutions - Connect Request"))
            .withBody(
                new Body()
                    .withText(
                        new Content().withCharset("UTF-8").withData(buildMessage(connectRequest))));

    SendEmailRequest sendEmailRequest =
        new SendEmailRequest()
            .withDestination(destination)
            .withMessage(message)
            .withSource(EMAIL_ADDRESS);

    amazonSimpleEmailService.sendEmail(sendEmailRequest);
  }

  private String buildMessage(ConnectRequest connectRequest) {
    return "Name: "
        + connectRequest.getFirstName()
        + " "
        + connectRequest.getLastName()
        + "\nCompany: "
        + connectRequest.getCompanyName()
        + "\nEmail: "
        + connectRequest.getEmail()
        + "\nPhone: "
        + connectRequest.getPhoneNumber()
        + "\nMessage: "
        + connectRequest.getMessage();
  }
}
