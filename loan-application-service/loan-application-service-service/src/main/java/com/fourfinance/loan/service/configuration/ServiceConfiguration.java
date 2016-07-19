package com.fourfinance.loan.service.configuration;

import com.fourfinance.loan.model.configuration.ModelConfiguration;
import com.fourfinance.loan.service.BaseService;
import org.dozer.DozerBeanMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import(ModelConfiguration.class)
@ComponentScan(basePackageClasses = BaseService.class)
public class ServiceConfiguration {

  @Bean
  public DozerBeanMapper dozerMapper () {
    return new DozerBeanMapper();
  }

}
