package com.tssimas.configserver.config;

import com.tssimas.configserver.model.ApplicationPath;
import com.tssimas.configserver.model.ConfigServerProperties;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnWebApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
@EnableGlobalMethodSecurity(securedEnabled = true)
@EnableWebSecurity
@ConditionalOnWebApplication
@EnableConfigurationProperties(ConfigServerProperties.class)
@RequiredArgsConstructor
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private ConfigServerProperties configServerProperties;

    PasswordEncoder encoder =
            PasswordEncoderFactories.createDelegatingPasswordEncoder();

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable();


        for (ApplicationPath path : configServerProperties.getPaths()) {
            if (path.getRequiredRoles() != null) {
                http.authorizeRequests().antMatchers(path.getPath()).hasAnyRole(path.getRequiredRoles());
            } else {
                http.authorizeRequests().antMatchers(path.getPath()).permitAll();
            }
        }

        http.httpBasic().and().cors();
    }

    @Bean
    public InMemoryUserDetailsManager inMemoryUserDetailsManager() {
        final InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();

        configServerProperties.getClients().forEach(client -> {
            manager.createUser(User.withUsername(client.getUsername())
                    .password(encoder.encode(client.getPassword()))
                    .roles(client.getRoles())
                    .build());
        });

        return manager;
    }

}
