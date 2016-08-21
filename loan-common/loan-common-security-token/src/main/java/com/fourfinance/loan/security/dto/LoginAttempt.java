package com.fourfinance.loan.security.dto;

import org.pojomatic.Pojomatic;
import org.pojomatic.annotations.AutoProperty;

@AutoProperty
public class LoginAttempt {

  private String email;
  private String password;

  public String getEmail() {
    return email;
  }

  public LoginAttempt setEmail(final String email) {
    this.email = email;
    return this;
  }

  public String getPassword() {
    return password;
  }

  public LoginAttempt setPassword(final String password) {
    this.password = password;
    return this;
  }

  @Override
  public int hashCode() {
    return Pojomatic.hashCode(this);
  }

  @Override
  public String toString() {
    return Pojomatic.toString(this);
  }

  @Override
  public boolean equals(Object o) {
    return Pojomatic.equals(this, o);
  }

}
