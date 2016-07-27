package com.fourfinance.loan;

import com.fourfinance.loan.configuration.LoanApplication;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application {

  public static void main(String[] args) {
    SpringApplication.run(LoanApplication.class, args);
  }

}
