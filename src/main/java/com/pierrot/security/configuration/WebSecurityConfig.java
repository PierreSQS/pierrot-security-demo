package com.pierrot.security.configuration;

import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
                .withUser("Pierrot")
                    .password("Pierrot123")
                    .authorities("ROLE_USER")
                .and()
                .withUser("Odile")
                    .password("Odile123")
                    .authorities("ROLE_USER");

    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        // Not implemented yet
    }
}
