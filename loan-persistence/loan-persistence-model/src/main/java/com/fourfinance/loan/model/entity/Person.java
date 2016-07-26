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
  @Column(name = "identificationnumber", nullable = false, length = 20)
  private String identificationNumber;
  @Column(name = "firstname", nullable = false, length = 20)
  private String firstName;
  @Column(name = "lastname", nullable = false, length = 20)
  private String lastName;

  public Long getId() {
    return id;
  }

  public Person setId(final Long id) {
    this.id = id;
    return this;
  }

  public String getFirstName() {
    return firstName;
  }

  public Person setFirstName(final String firstName) {
    this.firstName = firstName;
    return this;
  }

  public String getIdentificationNumber() {
    return identificationNumber;
  }

  public Person setIdentificationNumber(final String identificationNumber) {
    this.identificationNumber = identificationNumber;
    return this;
  }

  public String getLastName() {
    return lastName;
  }

  public Person setLastName(final String lastName) {
    this.lastName = lastName;
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
