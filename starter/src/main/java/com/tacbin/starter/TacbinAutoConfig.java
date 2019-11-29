package com.tacbin.starter;

import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Description
 * Author liuweibin
 * Date 2019/11/29 14:54
 **/
@Configuration
@ConditionalOnClass({Person.class})
@EnableConfigurationProperties(TacbinProperties.class)
public class TacbinAutoConfig {
    private final TacbinProperties properties;

    public TacbinAutoConfig(TacbinProperties properties) {
        this.properties = properties;
    }

    @Bean
    public Person getPerson() {
        return new Person(properties.getName(), properties.getAge());
    }

}
