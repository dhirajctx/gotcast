package com.gotcast.gotcast.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;


@Configuration
@EnableWebSecurity
public class SecurityConfig {

    // 1️⃣ Password encoder
    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    // 2️⃣ In-memory users
    @Bean
    public UserDetailsService userDetailsService(PasswordEncoder encoder) {
        InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();
        manager.createUser(User.withUsername("admin")
                .password(encoder.encode("Admin123"))
                .roles("ADMIN")
                .build());
        manager.createUser(User.withUsername("user")
                .password(encoder.encode("User123"))
                .roles("USER")
                .build());
        return manager;
    }

    // 3️⃣ Security rules
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .csrf(AbstractHttpConfigurer::disable)
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers(HttpMethod.GET, "/getActors").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.POST, "/actors/**").authenticated()
                        .requestMatchers(HttpMethod.PUT, "/actors/**").authenticated()
                        .requestMatchers(HttpMethod.DELETE, "/actors/**").authenticated()
                        .anyRequest().authenticated()
                )
                // 🔑 Basic Auth
                .httpBasic(Customizer.withDefaults());

        return http.build();
    }

}
