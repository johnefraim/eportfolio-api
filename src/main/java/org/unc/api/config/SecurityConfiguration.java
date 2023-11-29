package org.unc.api.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;


@Configuration
@EnableWebSecurity
public class SecurityConfiguration {

        @Bean
        SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

            http.authorizeHttpRequests(req -> req.requestMatchers("/", "/register").permitAll()
            .requestMatchers("/admin/**").hasRole("DEAN")
            .requestMatchers("/student/**").hasRole("STUDENT")
            .requestMatchers("/programhead/**").hasRole("PROGRAMHEAD")
            .anyRequest().authenticated()
            )
            .formLogin(login -> login.loginPage("/login")
            .permitAll())
            .logout(logout -> logout.permitAll());
            
            return http.build();
        }

        @Bean
        PasswordEncoder passwordEncoder() {return new BCryptPasswordEncoder();}
        
}

