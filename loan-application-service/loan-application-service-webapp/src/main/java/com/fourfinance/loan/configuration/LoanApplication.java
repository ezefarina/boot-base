package com.fourfinance.loan.configuration;

import com.fourfinance.loan.controller.BaseController;
import com.fourfinance.loan.service.configuration.ServiceConfiguration;
import liquibase.integration.spring.SpringLiquibase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.web.SpringBootServletInitializer;
import org.springframework.context.annotation.*;
import org.springframework.core.env.Environment;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.thymeleaf.extras.java8time.dialect.Java8TimeDialect;

import javax.sql.DataSource;

@Import(ServiceConfiguration.class)
@ComponentScan(basePackageClasses = BaseController.class)
@PropertySource(ignoreResourceNotFound = true,
    value = {"classpath:db.properties","file:${user.home}/db.properties"})
@EnableWebMvc
public class LoanApplication extends SpringBootServletInitializer {

  @Autowired
  private Environment environment;

  @Autowired
  private DataSource dataSource;

  @Bean
  public Java8TimeDialect java8TimeDialect() {
    return new Java8TimeDialect();
  }

  @Bean
  public SpringLiquibase liquibase()  {
    SpringLiquibase liquibase = new SpringLiquibase();

    liquibase.setDropFirst(true);
    liquibase.setDataSource(dataSource);
    liquibase.setChangeLog("classpath:"+environment.getProperty("liquibase.change-log"));

    return liquibase;
  }

}
