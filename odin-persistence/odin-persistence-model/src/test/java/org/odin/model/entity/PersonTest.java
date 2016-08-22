package org.odin.model.entity;

import org.odin.model.ModelBaseTest;
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
    String username = RandomStringUtils.randomAlphanumeric(10);
    String email = RandomStringUtils.randomAlphanumeric(10);
    String password = RandomStringUtils.randomAlphanumeric(10);
    Person person = new Person()
        .setUsername(username)
        .setEmail(email)
        .setPassword(password);
    person = repository.save(person);
    assertThat(person, is(not(nullValue())));
    assertThat(person.getUsername(),is(username));
    assertThat(person.getEmail(),is(email));
    assertThat(person.getPassword(),is(password));
  }

}
