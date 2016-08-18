package com.fourfinance.loan.security.service;

import com.fourfinance.loan.model.entity.Person;
import com.fourfinance.loan.security.dto.LoginAttempt;
import com.fourfinance.loan.security.authentication.OdinUserDetails;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService {

  Person getByUsername (String username);
  OdinUserDetails getByUsernameAsUserDetails (String username);
  OdinUserDetails toUserDetails (Person person);
  UsernamePasswordAuthenticationToken toAuthenticationToken (LoginAttempt loginAttempt);

}
