package org.odin.model.configuration;

import org.odin.model.repository.BaseRepository;
import org.odin.model.entity.BaseEntity;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.orm.jpa.EntityScan;
import org.springframework.context.annotation.*;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EntityScan(basePackageClasses = BaseEntity.class)
@EnableJpaRepositories(basePackageClasses = BaseRepository.class)
@PropertySource(ignoreResourceNotFound = true,
    value = {"classpath:model.properties","file:${user.home}/model.properties"})
@EnableAutoConfiguration
public class ModelConfiguration {

}
