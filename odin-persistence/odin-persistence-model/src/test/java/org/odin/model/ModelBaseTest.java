package org.odin.model;

import org.odin.datasource.configuration.DataSourceConfiguration;
import org.odin.model.configuration.ModelTestConfiguration;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@ContextConfiguration(classes = {ModelTestConfiguration.class,DataSourceConfiguration.class})
@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
public abstract class ModelBaseTest {

  @PersistenceContext
  protected EntityManager entityManager;

}
