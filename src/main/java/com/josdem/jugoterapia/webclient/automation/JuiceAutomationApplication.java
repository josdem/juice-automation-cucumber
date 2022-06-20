package com.josdem.jugoterapia.webclient.automation;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;

@SpringBootApplication
@ComponentScan(basePackages = "com.josdem.jugoterapia.webclient")
@PropertySource("classpath:application.properties")
public class JuiceAutomationApplication {

  public static void main(String[] args) {
    SpringApplication.run(JuiceAutomationApplication.class, args);
  }
}
