package com.lkreski.homedoc;

import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;


public class DataSourceBean {


    public DataSource dataSource() {
        return DataSourceBuilder
                .create()
                .username("postgres")
                .password("951230")
                .url("jdbc:postgresql://localhost:5432/homedoc")
                .driverClassName("org.postgresql.Driver")
                .build();

    }
}
