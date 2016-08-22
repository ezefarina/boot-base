package org.odin.security.service;

import org.odin.model.entity.Person;
import org.odin.security.dto.LoginAttempt;
import org.odin.security.authentication.OdinUserDetails;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService {

  Person getByUsername (String username);
  OdinUserDetails getByUsernameAsUserDetails (String username);
  OdinUserDetails toUserDetails (Person person);
  UsernamePasswordAuthenticationToken toAuthenticationToken (LoginAttempt loginAttempt);

}
