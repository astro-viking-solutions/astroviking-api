package com.astroviking.api.models;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ConnectRequest {

  private String firstName;
  private String lastName;
  private String email;
  private String phoneNumber;
  private String companyName;

  @NotEmpty(message = "Message can not be empty")
  @NotNull(message = "You must provide a message")
  @ApiModelProperty(required = true)
  private String message;
}
