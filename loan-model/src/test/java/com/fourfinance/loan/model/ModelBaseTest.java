package com.fourfinance.loan.model;

import com.fourfinance.loan.model.configuration.ModelTestConfiguration;
import liquibase.integration.spring.SpringLiquibase;
import org.junit.runner.RunWith;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.sql.DataSource;

@ContextConfiguration(classes = ModelTestConfiguration.class)
@RunWith(SpringJUnit4ClassRunner.class)
@PropertySource(ignoreResourceNotFound = true,
    value = {"classpath:db.properties","file:${user.home}/db.properties"})
@Transactional
public abstract class ModelBaseTest {

  @Resource
  private Environment environment;

  @Resource
  private DataSource dataSource;

  @PersistenceContext
  protected EntityManager entityManager;

  @Bean
  public SpringLiquibase liquibase()  {
    SpringLiquibase liquibase = new SpringLiquibase();

    liquibase.setDropFirst(true);
    liquibase.setDataSource(dataSource);

    return liquibase;
  }

}
