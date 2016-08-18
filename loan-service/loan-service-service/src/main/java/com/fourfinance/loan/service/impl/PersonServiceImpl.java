package com.fourfinance.loan.service.impl;

import com.fourfinance.loan.service.PersonService;
import com.fourfinance.loan.model.entity.Person;
import com.fourfinance.loan.model.repository.PersonRepository;
import com.fourfinance.loan.service.BaseService;
import com.fourfinance.loan.service.common.dto.PersonDto;
import com.google.common.base.Preconditions;
import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonServiceImpl extends BaseService<PersonDto,Person> implements PersonService {

  private PersonRepository personRepository;

  @Autowired
  public PersonServiceImpl(DozerBeanMapper mapper, PersonRepository personRepository) {
    super(mapper);
    this.personRepository = personRepository;
  }

  @Override
  public PersonDto save(PersonDto personDto) {
    Person person = new Person();
    copyProperties(personDto, person);
    return translate(personRepository.save(person));
  }

  @Override
  public PersonDto getByUsername(String username) {
    Preconditions.checkNotNull(username,"username is required");
    return translate(personRepository.findByUsername(username));
  }

  @Override
  public PersonDto getByEmail(final String email) {
    Preconditions.checkNotNull(email,"email is required");
    return translate(personRepository.findByEmail(email));
  }

}
