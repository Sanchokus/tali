package com.aolisov.tali.config;

import com.aolisov.tali.data.properties.PropertiesHolder;
import com.aolisov.tali.data.store.ResponseStore;
import com.aolisov.tali.data.store.memory.InMemoryResponseStore;
import com.aolisov.tali.pinger.Pinger;
import com.aolisov.tali.pinger.SimpleHttpPinger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/**
 * Created by Alex on 4/14/2016.
 */
@Configuration
@EnableWebMvc
@ComponentScan("com.aolisov.tali")
@Import(SecurityConfig.class)
public class AppConfig {

    @Bean
    public PropertiesHolder propertiesHolder() {
        return new PropertiesHolder();
    }

    @Bean
    public ResponseStore responseStore() {
        return new InMemoryResponseStore();
    }

    @Bean
    public Pinger pinger() {
        return new SimpleHttpPinger();
    }
}
