package org.odin.model.util;

import org.odin.model.entity.Person;
import org.odin.model.repository.PersonRepository;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Component
public class ModelTestUtil {

  @Resource
  private PersonRepository personRepository;

  public Person createPerson () {
    Person person = new Person()
        .setUsername(RandomStringUtils.randomAlphabetic(10))
        .setEmail(RandomStringUtils.randomAlphabetic(10))
        .setPassword(RandomStringUtils.randomAlphabetic(10));
    return personRepository.save(person);
  }

}
