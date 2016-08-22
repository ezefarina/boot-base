package org.odin.service.webapp.configuration;

import org.odin.service.webapp.controller.BaseController;
import org.odin.datasource.configuration.DataSourceConfiguration;
import org.odin.model.configuration.ModelConfiguration;
import org.odin.security.authentication.SecurityConfig;
import org.odin.service.configuration.ServiceConfiguration;
import org.springframework.boot.context.web.SpringBootServletInitializer;
import org.springframework.context.annotation.*;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Import({DataSourceConfiguration.class, ModelConfiguration.class, ServiceConfiguration.class, JavaMelodyConfiguration.class, SecurityConfig.class})
@PropertySource(ignoreResourceNotFound = true,
  value = {"classpath:web.properties","file:${user.home}/web.properties"})
@ComponentScan(basePackageClasses = BaseController.class)
@EnableWebMvc
public class WebConfig extends SpringBootServletInitializer {

}
