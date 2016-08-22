package org.odin.security.authentication;

import org.odin.security.SecurityBase;
import org.odin.security.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.annotation.Order;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
@ComponentScan(basePackageClasses = SecurityBase.class)
@PropertySource(ignoreResourceNotFound = true,
  value = {"classpath:security.properties","file:${user.home}/security.properties"})
@Order(1)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

  @Autowired
  private UserService userService;

  @Autowired
  private TokenAuthenticationService tokenAuthenticationService;

  @Override
  protected void configure(HttpSecurity http) throws Exception {
    // CSRF not needed as JWT will control access
    http.csrf()
      .disable();

    http.exceptionHandling()
      .and()
      .anonymous()
      .and()
      .servletApi()
      .and()
      .headers()
      .cacheControl();

    http.authorizeRequests()
      .antMatchers("/api/**")
      .hasRole("USER")
      .antMatchers("/api/login")
      .permitAll();

    http.addFilterBefore(new StatelessLoginFilter("/api/login", tokenAuthenticationService, userService, authenticationManager()), UsernamePasswordAuthenticationFilter.class);

    http.addFilterBefore(new StatelessAuthenticationFilter(tokenAuthenticationService), UsernamePasswordAuthenticationFilter.class);
  }

  @Bean
  @Override
  public AuthenticationManager authenticationManagerBean() throws Exception {
    return super.authenticationManagerBean();
  }

  @Override
  protected void configure(AuthenticationManagerBuilder auth) throws Exception {
    auth.userDetailsService(userService)
      .passwordEncoder(new BCryptPasswordEncoder());
  }

  @Override
  protected UserDetailsService userDetailsService() {
    return userService;
  }

}
