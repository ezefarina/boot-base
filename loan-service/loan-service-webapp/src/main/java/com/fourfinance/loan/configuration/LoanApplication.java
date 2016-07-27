package com.fourfinance.loan.configuration;

import com.fourfinance.loan.controller.BaseController;
import com.fourfinance.loan.datasource.configuration.DataSourceConfiguration;
import com.fourfinance.loan.model.configuration.ModelConfiguration;
import com.fourfinance.loan.service.configuration.ServiceConfiguration;
import org.springframework.boot.context.web.SpringBootServletInitializer;
import org.springframework.context.annotation.*;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Import({DataSourceConfiguration.class, ModelConfiguration.class, ServiceConfiguration.class})
@ComponentScan(basePackageClasses = BaseController.class)
@EnableWebMvc
public class LoanApplication extends SpringBootServletInitializer {

}
