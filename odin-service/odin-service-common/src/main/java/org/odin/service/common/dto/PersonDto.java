package org.odin.service.common.dto;

import org.pojomatic.Pojomatic;
import org.pojomatic.annotations.AutoProperty;

import java.io.Serializable;

@AutoProperty
public class PersonDto implements Serializable {

  private Long id;
  private String username;
  private String email;
  private String password;

  public Long getId() {
    return id;
  }

  public PersonDto setId(final Long id) {
    this.id = id;
    return this;
  }

  public String getUsername() {
    return username;
  }

  public PersonDto setUsername(final String username) {
    this.username = username;
    return this;
  }

  public String getEmail() {
    return email;
  }

  public PersonDto setEmail(final String email) {
    this.email = email;
    return this;
  }

  public String getPassword() {
    return password;
  }

  public PersonDto setPassword(final String password) {
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
