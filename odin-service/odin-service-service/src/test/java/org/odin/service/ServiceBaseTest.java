package org.odin.service;

import org.odin.datasource.configuration.DataSourceConfiguration;
import org.odin.model.configuration.ModelConfiguration;
import org.odin.service.configuration.ServiceConfiguration;
import org.junit.runner.RunWith;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = {DataSourceConfiguration.class, ModelConfiguration.class, ServiceConfiguration.class})
public abstract class ServiceBaseTest {

}
