package com.revature.waaik.musicprofessionalsapp;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.zaxxer.hikari.HikariDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
@Configuration
@ComponentScan
public class SpringAppConfig {
    @Bean
    public DataSource dataSource() {
        HikariDataSource ds = new HikariDataSource();
        ds.setJdbcUrl("jdbc:h2:mem:dbmain;MODE=PostgreSQL;DATABASE_TO_LOWER=TRUE;INIT=runscript from 'classpath:proschema.sql'");
        ds.setUsername("wcp");
        ds.setPassword("wcp");
        return ds;
    }


    @Bean
    public ObjectMapper mapper() {
        return new ObjectMapper();
    }
}