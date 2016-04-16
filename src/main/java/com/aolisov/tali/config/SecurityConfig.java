package com.aolisov.tali.config;

import com.aolisov.tali.data.properties.AppProperties;
import com.aolisov.tali.data.properties.PropertiesHolder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.web.context.support.StandardServletEnvironment;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

/**
 * Created by Alex on 4/16/2016.
 */
@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    PropertiesHolder propertiesHolder;

    @Autowired
    public void configureGlobalSecurity(AuthenticationManagerBuilder auth) throws Exception {
        AppProperties appProperties = propertiesHolder.getProperties();
        auth.inMemoryAuthentication()
                .withUser(appProperties.getAdminUserName())
                .password(appProperties.getAdminPassword())
                .roles("ADMIN");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/**").hasRole("ADMIN")
                .and()
                .httpBasic()
                .and()
                .csrf().disable();
    }
}
