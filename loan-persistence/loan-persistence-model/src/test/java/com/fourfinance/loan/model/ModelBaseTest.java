package com.fourfinance.loan.model;

import com.fourfinance.loan.datasource.configuration.DataSourceConfiguration;
import com.fourfinance.loan.model.configuration.ModelTestConfiguration;
import liquibase.integration.spring.SpringLiquibase;
import org.junit.runner.RunWith;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.sql.DataSource;

@ContextConfiguration(classes = {ModelTestConfiguration.class,DataSourceConfiguration.class})
@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
public abstract class ModelBaseTest {

  @PersistenceContext
  protected EntityManager entityManager;

}
