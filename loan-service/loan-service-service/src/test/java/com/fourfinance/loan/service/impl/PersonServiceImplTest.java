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
        .setFirstName(RandomStringUtils.randomAlphabetic(10))
        .setLastName(RandomStringUtils.randomAlphabetic(10))
        .setIdentificationNumber(RandomStringUtils.randomNumeric(10));

    personService.save(person);

    new Verifications() {{
      Person capturedPerson;
      personRepository.save(capturedPerson = withCapture());

      assertThat(capturedPerson.getFirstName(), is(person.getFirstName()));
      assertThat(capturedPerson.getLastName(), is(person.getLastName()));
      assertThat(capturedPerson.getIdentificationNumber(),is(person.getIdentificationNumber()));
    }};
  }

  @Test
  public void testGetByIdentificationNumber () {
    final String id = RandomStringUtils.randomNumeric(10);

    new Expectations() {{
      personRepository.findByIdentificationNumber(id);
      result = new Person()
          .setId(321L);
    }};

    final PersonDto person = personService.getByIdentificationNumber(id);

    new Verifications() {{
      String capturedId;
      personRepository.findByIdentificationNumber(capturedId = withCapture());

      assertThat(capturedId, is(id));
      assertThat(person.getId(),is(321L));
    }};
  }

}
