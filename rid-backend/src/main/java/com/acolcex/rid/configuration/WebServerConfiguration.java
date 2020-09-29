package com.acolcex.rid.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.acolcex.rid.security.NoPasswordEncoder;

@Configuration
public class WebServerConfiguration {

	@Bean
    public NoPasswordEncoder bCryptPasswordEncoder() {
        return new NoPasswordEncoder();
    }
}
