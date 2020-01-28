package com.italia.soaproject.rest.configuration;


import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "com.italia.soaproject.rest.user, com.italia.soaproject.rest.library")
public class AppConfiguration {

}
