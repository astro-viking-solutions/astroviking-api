package com.astroviking.api.configuration;

import com.amazonaws.regions.Regions;
import com.amazonaws.services.simpleemail.AmazonSimpleEmailService;
import com.amazonaws.services.simpleemail.AmazonSimpleEmailServiceClientBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AwsClientConfiguration {

  @Bean
  public AmazonSimpleEmailService amazonSimpleEmailServiceClient() {
    return AmazonSimpleEmailServiceClientBuilder.standard().withRegion(Regions.US_EAST_1).build();
  }
}
