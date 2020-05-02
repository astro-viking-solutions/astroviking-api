package com.astroviking.api.services;

import com.amazonaws.services.simpleemail.AmazonSimpleEmailService;
import com.astroviking.api.dto.ConnectRequest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@ExtendWith(SpringExtension.class)
class EmailServiceTest {

  @Mock AmazonSimpleEmailService amazonSimpleEmailService;

  @InjectMocks EmailService emailService;

  @Test
  public void testSuccess() {
    ConnectRequest connectRequest = new ConnectRequest();
    connectRequest.setCompanyName("A company");
    connectRequest.setEmail("test@test.com");
    connectRequest.setFirstName("First");
    connectRequest.setLastName("Last");
    connectRequest.setMessage("Some message");
    connectRequest.setPhoneNumber("867-5309");

    emailService.sendEmail(connectRequest);

    verify(amazonSimpleEmailService, times(1)).sendEmail(any());
  }
}
