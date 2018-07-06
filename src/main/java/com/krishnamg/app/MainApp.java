package com.krishnamg.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;

import javax.sql.DataSource;

/**
 * Created by krishnamg on 4/8/17.
 */
@SpringBootApplication
@EnableAutoConfiguration
@ComponentScan(basePackages = "com.krishnamg.app")
public class MainApp  implements CommandLineRunner {

    @Autowired
    private DataSource dataSource;

    public static void main(String[] args) throws Exception  {
        SpringApplication.run(MainApp.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("Connection Polling datasource : "+ dataSource);  // check connection pooling
    }


}
