package com.fourfinance.loan.model.configuration;

import com.fourfinance.loan.model.repository.BaseRepository;
import com.fourfinance.loan.model.entity.BaseEntity;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.orm.jpa.EntityScan;
import org.springframework.context.annotation.*;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EntityScan(basePackageClasses = BaseEntity.class)
@EnableJpaRepositories(basePackageClasses = BaseRepository.class)
@PropertySource(ignoreResourceNotFound = true,
    value = {"classpath:db.properties","file:${user.home}/db.properties"})
@EnableAutoConfiguration
public class ModelConfiguration {

}
