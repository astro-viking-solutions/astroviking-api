package com.astroviking.api.controllers;

import com.astroviking.api.dto.EmailDTO;
import com.astroviking.api.services.EmailService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
class ConnectControllerTest {

  @Mock EmailService emailService;

  @InjectMocks ConnectController connectController;

  MockMvc mockMvc;

  @BeforeEach
  public void setup() {
    mockMvc = MockMvcBuilders.standaloneSetup(connectController).build();
  }

  @Test
  void connect() throws Exception {
    EmailDTO emailDTO = new EmailDTO();
    emailDTO.setCompanyName("A company");
    emailDTO.setEmail("test@test.com");
    emailDTO.setFirstName("First");
    emailDTO.setLastName("Last");
    emailDTO.setMessage("Some message");
    emailDTO.setPhoneNumber("867-5309");

    mockMvc
        .perform(
            post(ConnectController.BASE_URL)
                .content(asJsonString(emailDTO))
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
        .andExpect(status().isAccepted());

    verify(emailService, times(1)).sendEmail(emailDTO);
  }

  public static String asJsonString(final Object obj) {
    try {
      return new ObjectMapper().writeValueAsString(obj);
    } catch (Exception e) {
      throw new RuntimeException(e);
    }
  }
}
