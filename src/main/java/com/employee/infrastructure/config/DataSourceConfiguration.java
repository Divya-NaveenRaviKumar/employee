package com.employee.infrastructure.config;

import com.zaxxer.hikari.HikariDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class DataSourceConfiguration {

    @Primary
    @Bean
    @ConfigurationProperties(prefix = "spring.datasource")
    public HikariDataSource mainJdbcTemplate(@Value("${spring.datasource.url}") String url,
                                             @Value("${spring.datasource.username}") String username,
                                             @Value("${spring.datasource.password}") String password) {
        return DataSourceBuilder.create().type(HikariDataSource.class)
                .url(url)
                .username(username)
                .password(password)
                .build();
    }
}
