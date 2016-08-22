package org.odin.service.configuration;

import org.odin.service.BaseService;
import org.dozer.DozerBeanMapper;
import org.springframework.context.annotation.*;

@Configuration
@ComponentScan(basePackageClasses = BaseService.class)
@PropertySource(ignoreResourceNotFound = true,
    value = {"classpath:service.properties","file:${user.home}/service.properties"})
public class ServiceConfiguration {

  @Bean
  public DozerBeanMapper dozerMapper () {
    return new DozerBeanMapper();
  }

}
