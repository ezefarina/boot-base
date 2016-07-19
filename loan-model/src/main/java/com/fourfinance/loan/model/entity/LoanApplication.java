package com.fourfinance.loan.model.entity;

import org.hibernate.annotations.Type;
import org.joda.time.LocalDateTime;
import org.pojomatic.Pojomatic;
import org.pojomatic.annotations.AutoProperty;

import javax.persistence.*;

@AutoProperty
@Entity
@Table(name = "person_loan_application")
public class LoanApplication implements BaseEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "person_id", nullable = false)
  private Person person;
  @Column(nullable = false, updatable = false)
  private Double amount;
  @Column(nullable = false, updatable = false)
  private String ip;
  @Column(nullable = false, updatable = false)
  @Type(type = "org.jadira.usertype.dateandtime.joda.PersistentLocalDateTime")
  private LocalDateTime datetime;
  @Column(nullable = false)
  private Boolean approved;

  public Long getId() {
    return id;
  }

  public LoanApplication setId(Long id) {
    this.id = id;
    return this;
  }

  public String getIp() {
    return ip;
  }

  public LoanApplication setIp(final String ip) {
    this.ip = ip;
    return this;
  }

  public Person getPerson() {
    return person;
  }

  public LoanApplication setPerson(Person person) {
    this.person = person;
    return this;
  }

  public Double getAmount() {
    return amount;
  }

  public LoanApplication setAmount(Double amount) {
    this.amount = amount;
    return this;
  }

  public LocalDateTime getDatetime() {
    return datetime;
  }

  public LoanApplication setDatetime(LocalDateTime datetime) {
    this.datetime = datetime;
    return this;
  }

  public Boolean getApproved() {
    return approved;
  }

  public LoanApplication setApproved(Boolean approved) {
    this.approved = approved;
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
