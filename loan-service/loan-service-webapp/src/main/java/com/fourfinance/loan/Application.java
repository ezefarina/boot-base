package com.fourfinance.loan;

import com.fourfinance.loan.configuration.LoanApplication;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class Application {

  public static void main(String[] args) {
//    System.out.print(new BCryptPasswordEncoder().encode("123456"));
    SpringApplication.run(LoanApplication.class, args);
  }

}
