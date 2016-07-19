package com.fourfinance.loan.model.configuration;

import com.fourfinance.loan.model.util.ModelTestUtil;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import(ModelConfiguration.class)
@ComponentScan(basePackageClasses = ModelTestUtil.class)
public class ModelTestConfiguration {
}
