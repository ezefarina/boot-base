package com.fourfinance.loan.model.repository;

import com.fourfinance.loan.model.ModelBaseTest;
import com.fourfinance.loan.model.entity.Person;
import com.fourfinance.loan.model.util.ModelTestUtil;
import org.junit.Test;

import javax.annotation.Resource;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class PersonRepositoryTest extends ModelBaseTest {

  @Resource
  private ModelTestUtil testUtil;

  @Resource
  private PersonRepository personRepository;

  @Test
  public void testFindByUsername () {
    Person createdPerson = testUtil.createPerson();
    Person foundPerson = personRepository.findByUsername(createdPerson.getUsername());
    assertThat(foundPerson.getId(),is(createdPerson.getId()));
  }

}
