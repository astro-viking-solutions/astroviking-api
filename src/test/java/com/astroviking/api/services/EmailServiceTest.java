package com.astroviking.api.services;

import com.amazonaws.services.simpleemail.AmazonSimpleEmailService;
import com.astroviking.api.dto.EmailDTO;
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
  public void connect() {
    EmailDTO emailDTO = new EmailDTO();
    emailDTO.setCompanyName("A company");
    emailDTO.setEmail("test@test.com");
    emailDTO.setFirstName("First");
    emailDTO.setLastName("Last");
    emailDTO.setMessage("Some message");
    emailDTO.setPhoneNumber("867-5309");

    emailService.sendEmail(emailDTO);

    verify(amazonSimpleEmailService, times(1)).sendEmail(any());
  }
}
