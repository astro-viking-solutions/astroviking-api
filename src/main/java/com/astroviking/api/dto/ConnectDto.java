package com.astroviking.api.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ConnectDto {

  private String firstName;
  private String lastName;
  private String email;
  private String phoneNumber;
  private String companyName;
  private String message;
}
