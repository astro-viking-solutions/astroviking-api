package com.astroviking.api.controllers;

import com.astroviking.api.models.ConnectRequest;
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
    ConnectRequest connectRequest = new ConnectRequest();
    connectRequest.setCompanyName("A company");
    connectRequest.setEmail("test@test.com");
    connectRequest.setFirstName("First");
    connectRequest.setLastName("Last");
    connectRequest.setMessage("Some message");
    connectRequest.setPhoneNumber("867-5309");

    mockMvc
        .perform(
            post(ConnectController.BASE_URL)
                .content(asJsonString(connectRequest))
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
        .andExpect(status().isCreated());

    verify(emailService, times(1)).sendEmail(connectRequest);
  }

  @Test
  void connectValidation() throws Exception {
    ConnectRequest connectRequest = new ConnectRequest();
    connectRequest.setCompanyName("A company");
    connectRequest.setEmail("test@test.com");
    connectRequest.setFirstName("First");
    connectRequest.setLastName("Last");
    connectRequest.setPhoneNumber("867-5309");

    mockMvc
        .perform(
            post(ConnectController.BASE_URL)
                .content(asJsonString(connectRequest))
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
        .andExpect(status().isBadRequest());

    verify(emailService, times(0)).sendEmail(connectRequest);
  }

  public static String asJsonString(final Object obj) {
    try {
      return new ObjectMapper().writeValueAsString(obj);
    } catch (Exception e) {
      throw new RuntimeException(e);
    }
  }
}
