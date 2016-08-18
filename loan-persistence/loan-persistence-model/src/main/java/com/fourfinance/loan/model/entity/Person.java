package com.fourfinance.loan.model.entity;

import org.pojomatic.Pojomatic;
import org.pojomatic.annotations.AutoProperty;

import javax.persistence.*;
import java.io.Serializable;

@AutoProperty
@Entity
public class Person implements Serializable {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  @Column(name = "username", nullable = false, length = 20)
  private String username;
  @Column(name = "email", nullable = false, length = 120)
  private String email;
  @Column(name = "password", nullable = false, length = 20)
  private String password;

  public Long getId() {
    return id;
  }

  public Person setId(final Long id) {
    this.id = id;
    return this;
  }

  public String getUsername() {
    return username;
  }

  public Person setUsername(final String username) {
    this.username = username;
    return this;
  }

  public String getEmail() {
    return email;
  }

  public Person setEmail(final String email) {
    this.email = email;
    return this;
  }

  public String getPassword() {
    return password;
  }

  public Person setPassword(final String password) {
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
