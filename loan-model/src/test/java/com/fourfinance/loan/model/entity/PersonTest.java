package com.fourfinance.loan.model.entity;

import com.fourfinance.loan.model.ModelBaseTest;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.Before;
import org.junit.Test;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;

import static org.hamcrest.CoreMatchers.nullValue;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsNot.not;

public class PersonTest extends ModelBaseTest {

  private SimpleJpaRepository<Person, Long> repository;

  @Before
  public void init() {
    repository = new SimpleJpaRepository<>(Person.class, entityManager);
  }

  @Test
  public void test () {
    String firstName = RandomStringUtils.randomAlphanumeric(10);
    String lastName = RandomStringUtils.randomAlphanumeric(10);
    String identificationNumber = RandomStringUtils.randomAlphanumeric(10);
    Person person = new Person()
        .setFirstName(firstName)
        .setLastName(lastName)
        .setIdentificationNumber(identificationNumber);
    person = repository.save(person);
    assertThat(person, is(not(nullValue())));
    assertThat(person.getFirstName(),is(firstName));
    assertThat(person.getLastName(),is(lastName));
    assertThat(person.getIdentificationNumber(),is(identificationNumber));
  }

}
