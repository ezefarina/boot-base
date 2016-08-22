package org.odin.service;

import org.odin.service.common.dto.PersonDto;

public interface PersonService {

  PersonDto save(PersonDto personDto);
  PersonDto getByUsername(String username);
  PersonDto getByEmail(String email);

}
