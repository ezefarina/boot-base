package com.fourfinance.loan.model.configuration;

import com.fourfinance.loan.datasource.configuration.DataSourceConfiguration;
import com.fourfinance.loan.model.util.ModelTestUtil;
import liquibase.integration.spring.SpringLiquibase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.core.env.Environment;

import javax.annotation.Resource;
import javax.sql.DataSource;

@Configuration
@Import({DataSourceConfiguration.class, ModelConfiguration.class})
@ComponentScan(basePackageClasses = ModelTestUtil.class)
public class ModelTestConfiguration {

  @Resource
  private DataSource dataSource;

  @Resource
  private Environment environment;

  @Bean
  public SpringLiquibase liquibase()  {
    SpringLiquibase liquibase = new SpringLiquibase();

    liquibase.setDropFirst(true);
    liquibase.setDataSource(dataSource);
    liquibase.setChangeLog(environment.getProperty("liquibase.change-log"));

    return liquibase;
  }

}
