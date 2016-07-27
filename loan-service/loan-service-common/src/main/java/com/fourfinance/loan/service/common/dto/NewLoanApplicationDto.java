package com.fourfinance.loan.service.common.dto;

import org.pojomatic.Pojomatic;
import org.pojomatic.annotations.AutoProperty;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@AutoProperty
public class NewLoanApplicationDto implements Serializable {

  @Min(0)
  @Max(999999)
  @NotNull
  private Double amount;
  @NotNull
  private String identificationNumber;
  private String firstName;
  private String lastName;
  private int step;

  public String getIdentificationNumber() {
    return identificationNumber;
  }

  public NewLoanApplicationDto setIdentificationNumber(final String identificationNumber) {
    this.identificationNumber = identificationNumber;
    return this;
  }

  public Double getAmount() {
    return amount;
  }

  public NewLoanApplicationDto setAmount(final Double amount) {
    this.amount = amount;
    return this;
  }

  public String getFirstName() {
    return firstName;
  }

  public NewLoanApplicationDto setFirstName(String firstName) {
    this.firstName = firstName;
    return this;
  }

  public String getLastName() {
    return lastName;
  }

  public NewLoanApplicationDto setLastName(String lastName) {
    this.lastName = lastName;
    return this;
  }

  public int getStep() {
    return step;
  }

  public NewLoanApplicationDto setStep(final int step) {
    this.step = step;
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
