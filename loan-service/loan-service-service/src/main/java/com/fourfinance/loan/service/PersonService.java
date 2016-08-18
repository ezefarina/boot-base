package com.fourfinance.loan.service;

import com.fourfinance.loan.service.common.dto.PersonDto;

public interface PersonService {

  PersonDto save(PersonDto personDto);
  PersonDto getByUsername(String username);
  PersonDto getByEmail(String email);

}
