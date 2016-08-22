package org.odin.security.authentication;

import org.pojomatic.Pojomatic;
import org.pojomatic.annotations.AutoProperty;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

import java.util.Collection;

@AutoProperty
public class OdinUserDetails extends User {

  public OdinUserDetails(final String username, final String password, final Collection<? extends GrantedAuthority> authorities) {
    super(username, password, authorities);
  }

  public OdinUserDetails(final String username, final String password, final boolean enabled, final boolean accountNonExpired, final boolean credentialsNonExpired,
    final boolean accountNonLocked, final Collection<? extends GrantedAuthority> authorities) {
    super(username, password, enabled, accountNonExpired, credentialsNonExpired, accountNonLocked, authorities);
  }

  @Override
  public int hashCode() {
    return Pojomatic.hashCode(this);
  }

  @Override
  public String toString() {
    return Pojomatic.toString(this);
  }

  @Override
  public boolean equals(Object o) {
    return Pojomatic.equals(this, o);
  }

}
