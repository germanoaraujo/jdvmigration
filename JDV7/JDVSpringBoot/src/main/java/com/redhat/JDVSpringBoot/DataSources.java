package com.redhat.JDVSpringBoot;

import javax.activation.DataSource;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DataSources {

    @ConfigurationProperties(prefix = "spring.datasource.mydb")
    @Bean
    public javax.sql.DataSource mydb() {
        return DataSourceBuilder.create().build();
    }
}
