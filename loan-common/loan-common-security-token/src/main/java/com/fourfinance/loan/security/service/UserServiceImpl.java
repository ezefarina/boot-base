package com.fourfinance.loan.security.service;

import com.fourfinance.loan.model.entity.Person;
import com.fourfinance.loan.model.repository.PersonRepository;
import com.fourfinance.loan.security.authentication.OdinUserDetails;
import com.fourfinance.loan.security.dto.LoginAttempt;
import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

/**
 * In case you don't want this to connect straight to the DB you could reimplement with a RestTemplate or OkHttp consuming a central service
 */
@Component
public class UserServiceImpl implements UserService {

  private PersonRepository personRepository;

  @Autowired
  public UserServiceImpl(PersonRepository personRepository) {
    this.personRepository = personRepository;
  }

  @Override
  public Person getByUsername(final String username) {
    return personRepository.findByUsername(username);
  }

  @Override
  public OdinUserDetails getByUsernameAsUserDetails(final String username) {
    return toUserDetails(getByUsername(username));
  }

  @Override
  public OdinUserDetails toUserDetails(final Person person) {
    return new OdinUserDetails(person.getUsername(), person.getPassword(),
          Lists.newArrayList(new SimpleGrantedAuthority("USER")));
  }

  @Override
  public UsernamePasswordAuthenticationToken toAuthenticationToken(final LoginAttempt loginAttempt) {
    return new UsernamePasswordAuthenticationToken(loginAttempt.getEmail(), loginAttempt.getPassword());
  }

  @Override
  public UserDetails loadUserByUsername(final String username) throws UsernameNotFoundException {
    return getByUsernameAsUserDetails(username);
  }

}
