package com.fourfinance.loan.service.impl;

import com.fourfinance.loan.model.entity.Person;
import com.fourfinance.loan.model.repository.PersonRepository;
import com.fourfinance.loan.service.ServiceBaseTest;
import com.fourfinance.loan.service.common.dto.PersonDto;
import mockit.*;
import org.apache.commons.lang3.RandomStringUtils;
import org.dozer.DozerBeanMapper;
import org.junit.Before;
import org.junit.Test;

import javax.annotation.Resource;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class PersonServiceImplTest extends ServiceBaseTest {

  private PersonServiceImpl personService;

  @Mocked
  private PersonRepository personRepository;

  @Resource
  private DozerBeanMapper mapper;

  @Before
  public void init() {
    personService = new PersonServiceImpl(mapper,personRepository);
  }

  @Test
  public void testSave () {
    final PersonDto person = new PersonDto()
        .setUsername(RandomStringUtils.randomAlphabetic(10))
        .setEmail(RandomStringUtils.randomAlphabetic(10))
        .setPassword(RandomStringUtils.randomNumeric(10));

    personService.save(person);

    new Verifications() {{
      Person capturedPerson;
      personRepository.save(capturedPerson = withCapture());

      assertThat(capturedPerson.getUsername(), is(person.getUsername()));
      assertThat(capturedPerson.getEmail(), is(person.getEmail()));
      assertThat(capturedPerson.getPassword(),is(person.getPassword()));
    }};
  }

  @Test
  public void testGetByUsername () {
    final String username = RandomStringUtils.randomNumeric(10);

    new Expectations() {{
      personRepository.findByUsername(username);
      result = new Person()
          .setId(321L);
    }};

    final PersonDto person = personService.getByUsername(username);

    new Verifications() {{
      String capturedId;
      personRepository.findByUsername(capturedId = withCapture());

      assertThat(capturedId, is(username));
      assertThat(person.getId(),is(321L));
    }};
  }

}
