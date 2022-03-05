package com.pierrot.security.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
                .withUser("Pierrot")
                    .password("{bcrypt}$2a$10$u5K1acOFC7HZrrPjTwQVv.3zQWkUrk7afB21UQeipOzZJ/9w74lR.")
                    .authorities("ROLE_USER")
                .and()
                .withUser("Odile")
                    .password("{bcrypt}$2a$10$oxvtnswHxzkwTF3ts/k0futaOdwQXF7yGN.8vLiveXdCjdDO93bc6")
                    .authorities("ROLE_USER");

    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                    .antMatchers("/login")
                    .permitAll()
                    .anyRequest().authenticated()
                .and()
                    .formLogin()
                    .permitAll()
                .and()
                .logout().permitAll();
    }
}
