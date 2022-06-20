package com.josdem.jugoterapia.webclient.automation;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.josdem.jugoterapia.webclient")
public class JuiceAutomationApplication {

  public static void main(String[] args) {
    SpringApplication.run(JuiceAutomationApplication.class, args);
  }
}
