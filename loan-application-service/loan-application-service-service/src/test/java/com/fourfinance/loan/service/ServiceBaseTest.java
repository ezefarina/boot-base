package com.fourfinance.loan.service;

import com.fourfinance.loan.service.configuration.ServiceConfiguration;
import org.junit.runner.RunWith;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = {ServiceConfiguration.class})
public abstract class ServiceBaseTest {

}
