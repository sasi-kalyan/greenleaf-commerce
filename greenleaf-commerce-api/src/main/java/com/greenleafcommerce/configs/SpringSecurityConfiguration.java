package com.greenleafcommerce.configs;

import com.greenleafcommerce.common.Role;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
@ComponentScan(basePackages = "com.greenleafcommerce")
public class SpringSecurityConfiguration {

    private final Logger log = LoggerFactory.getLogger(SpringSecurityConfiguration.class);

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http){

        log.info("Inside -- filterChain");

        http.csrf(
                csrf -> csrf.disable()
        ).headers(headers ->
                headers.frameOptions(
                        frame -> frame.disable()
                )
        ).authorizeHttpRequests(
                auth -> auth.requestMatchers("/h2-console/**",
                                "/swagger-ui/**", "/v3/api-docs/**", "/error", "/actuator/**")
                        .permitAll()
                        .requestMatchers("/api/admin/**")
                        .hasRole("ADMIN")
                        .anyRequest()
                        .authenticated()
        ).httpBasic(Customizer.withDefaults());

        return http.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
}
