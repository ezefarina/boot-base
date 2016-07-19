package com.fourfinance.loan.service.common.dto;

import org.pojomatic.Pojomatic;
import org.pojomatic.annotations.AutoProperty;

import java.io.Serializable;

@AutoProperty
public class PersonDto implements Serializable {

  private Long id;
  private String identificationNumber;
  private String firstName;
  private String lastName;

  public Long getId() {
    return id;
  }

  public PersonDto setId(final Long id) {
    this.id = id;
    return this;
  }

  public String getIdentificationNumber() {
    return identificationNumber;
  }

  public PersonDto setIdentificationNumber(final String identificationNumber) {
    this.identificationNumber = identificationNumber;
    return this;
  }

  public String getFirstName() {
    return firstName;
  }

  public PersonDto setFirstName(final String firstName) {
    this.firstName = firstName;
    return this;
  }

  public String getLastName() {
    return lastName;
  }

  public PersonDto setLastName(final String lastName) {
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
