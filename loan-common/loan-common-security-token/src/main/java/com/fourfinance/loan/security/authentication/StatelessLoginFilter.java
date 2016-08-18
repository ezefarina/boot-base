package com.fourfinance.loan.security.authentication;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fourfinance.loan.security.dto.LoginAttempt;
import com.fourfinance.loan.security.service.UserService;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

class StatelessLoginFilter extends AbstractAuthenticationProcessingFilter {

  private final TokenAuthenticationService tokenAuthenticationService;
  private final UserService userService;

  public StatelessLoginFilter(String urlMapping, TokenAuthenticationService tokenAuthenticationService, UserService userService, AuthenticationManager authenticationManager) {
    super(urlMapping);
    this.tokenAuthenticationService = tokenAuthenticationService;
    this.userService = userService;
    setAuthenticationManager(authenticationManager);
  }

  @Override
  public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException, IOException, ServletException {
    final LoginAttempt loginAttempt = new ObjectMapper().readValue(request.getInputStream(), LoginAttempt.class);
    final UsernamePasswordAuthenticationToken loginToken = userService.toAuthenticationToken(loginAttempt);
    return getAuthenticationManager().authenticate(loginToken);
  }

  @Override
  protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain, Authentication authResult)
    throws IOException, ServletException {
    final OdinUserDetails authenticatedUser = userService.getByUsernameAsUserDetails(authResult.getName());
    final UserAuthentication userAuthentication = new UserAuthentication(authenticatedUser);

    tokenAuthenticationService.addAuthentication(response, userAuthentication);

    SecurityContextHolder.getContext()
      .setAuthentication(userAuthentication);
  }
}
