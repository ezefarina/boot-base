package com.fourfinance.loan.service;

import com.fourfinance.loan.datasource.configuration.DataSourceConfiguration;
import com.fourfinance.loan.model.configuration.ModelConfiguration;
import com.fourfinance.loan.service.configuration.ServiceConfiguration;
import org.junit.runner.RunWith;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = {DataSourceConfiguration.class, ModelConfiguration.class, ServiceConfiguration.class})
public abstract class ServiceBaseTest {

}
