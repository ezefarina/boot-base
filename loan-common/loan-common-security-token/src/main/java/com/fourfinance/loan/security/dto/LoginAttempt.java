package com.fourfinance.loan.security.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.pojomatic.Pojomatic;
import org.pojomatic.annotations.AutoProperty;

@AutoProperty
public class LoginAttempt {

  private String username;
  private String password;

  public String getUsername() {
    return username;
  }

  public LoginAttempt setUsername(final String username) {
    this.username = username;
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
