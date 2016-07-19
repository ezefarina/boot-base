package com.fourfinance.loan.service.common.dto;

import org.joda.time.LocalDateTime;
import org.pojomatic.Pojomatic;
import org.pojomatic.annotations.AutoProperty;

import java.io.Serializable;

@AutoProperty
public class LoanApplicationDto implements Serializable {

  private Long id;
  private PersonDto person;
  private Double amount;
  private LocalDateTime datetime;
  private Boolean approved;
  private String ip;

  public Long getId() {
    return id;
  }

  public LoanApplicationDto setId(final Long id) {
    this.id = id;
    return this;
  }

  public PersonDto getPerson() {
    return person;
  }

  public LoanApplicationDto setPerson(final PersonDto person) {
    this.person = person;
    return this;
  }

  public Double getAmount() {
    return amount;
  }

  public LoanApplicationDto setAmount(final Double amount) {
    this.amount = amount;
    return this;
  }

  public LocalDateTime getDatetime() {
    return datetime;
  }

  public LoanApplicationDto setDatetime(final LocalDateTime datetime) {
    this.datetime = datetime;
    return this;
  }

  public Boolean getApproved() {
    return approved;
  }

  public LoanApplicationDto setApproved(final Boolean approved) {
    this.approved = approved;
    return this;
  }

  public String getIp() {
    return ip;
  }

  public LoanApplicationDto setIp(final String ip) {
    this.ip = ip;
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
