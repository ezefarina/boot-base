package org.odin.commons.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource(ignoreResourceNotFound = true,
    value = {"classpath:common.properties",
             "file:${user.home}/common.properties"})
public class CommonConfiguration {

}
