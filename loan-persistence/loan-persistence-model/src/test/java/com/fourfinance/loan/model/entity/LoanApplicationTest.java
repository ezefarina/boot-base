package com.fourfinance.loan.model.entity;

import com.fourfinance.loan.model.ModelBaseTest;
import org.apache.commons.lang3.RandomStringUtils;
import org.joda.time.LocalDateTime;
import org.junit.Before;
import org.junit.Test;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;

import java.util.Random;

import static org.hamcrest.CoreMatchers.nullValue;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsNot.not;

public class LoanApplicationTest extends ModelBaseTest {

  private SimpleJpaRepository<LoanApplication, Long> repository;
  private SimpleJpaRepository<Person, Long> personRepository;
  private Random random;

  @Before
  public void init() {
    repository = new SimpleJpaRepository<>(LoanApplication.class, entityManager);
    personRepository = new SimpleJpaRepository<>(Person.class, entityManager);
    random = new Random();
  }

  @Test
  public void test () {
    String ip = RandomStringUtils.randomAlphanumeric(10);
    LocalDateTime now = LocalDateTime.now();
    Double amount = new Double(random.nextInt());
    Person person = new Person()
        .setFirstName(RandomStringUtils.randomAlphabetic(10))
        .setLastName(RandomStringUtils.randomAlphabetic(10))
        .setIdentificationNumber(RandomStringUtils.randomAlphabetic(10));
    person = personRepository.save(person);
    LoanApplication loanApplication = new LoanApplication()
        .setIp(ip)
        .setDatetime(now)
        .setPerson(person)
        .setAmount(amount)
        .setApproved(true);
    loanApplication = repository.save(loanApplication);
    assertThat(loanApplication, is(not(nullValue())));
    assertThat(loanApplication.getPerson().getId(),is(person.getId()));
    assertThat(loanApplication.getAmount(),is(amount));
    assertThat(loanApplication.getIp(),is(ip));
    assertThat(loanApplication.getApproved(),is(true));
    assertThat(loanApplication.getDatetime(),is(now));
  }

}
