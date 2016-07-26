package com.fourfinance.loan.datasource.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource(ignoreResourceNotFound = true,
    value = {"classpath:db.properties",
             "file:${user.home}/db.properties",
             "classpath:db-test.properties"})
public class DataSourceConfiguration {

}
