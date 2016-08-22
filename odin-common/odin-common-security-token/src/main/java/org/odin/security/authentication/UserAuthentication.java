package org.odin.security.authentication;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;

class UserAuthentication implements Authentication {

  private final OdinUserDetails userDetails;
  private boolean authenticated = true;

  public UserAuthentication(OdinUserDetails userDetails) {
    this.userDetails = userDetails;
  }

  @Override
  public Collection<? extends GrantedAuthority> getAuthorities() {
    return userDetails.getAuthorities();
  }

  @Override
  public Object getCredentials() {
    return userDetails.getPassword();
  }

  @Override
  public org.springframework.security.core.userdetails.UserDetails getDetails() {
    return userDetails;
  }

  @Override
  public Object getPrincipal() {
    return userDetails.getUsername();
  }

  @Override
  public boolean isAuthenticated() {
    return authenticated;
  }

  @Override
  public void setAuthenticated(boolean authenticated) throws IllegalArgumentException {
    this.authenticated = authenticated;
  }

  @Override
  public String getName() {
    return userDetails.getUsername();
  }

}
