package org.unc.api.config;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.unc.api.user.CustomAuthenticationSuccessHandler;


@Configuration
@EnableWebSecurity
public class SecurityConfiguration {

    @Autowired
    private CustomAuthenticationSuccessHandler customAuthenticationSuccessHandler;

    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
        .authorizeHttpRequests(req -> req
            .requestMatchers("/", "/register", "/js/**").permitAll()
            .requestMatchers("/admin/**").hasAuthority("ROLE_DEAN")
            .requestMatchers("/student/**").hasAuthority("ROLE_STUDENT")
            .requestMatchers("/programhead/**").hasAuthority("ROLE_PROGRAM_HEAD")
            .anyRequest().authenticated()
        )
        .formLogin(login -> login
            .loginPage("/login")
            .successHandler(customAuthenticationSuccessHandler)
            .permitAll()
        )
        .exceptionHandling(handling -> handling.accessDeniedHandler(accessDeniedHandler()))
        .logout(logout -> logout.permitAll());

        return http.build();
    }

    @Bean
    PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public AccessDeniedHandler accessDeniedHandler() {
        return (request, response, accessDeniedException) -> {
            response.sendRedirect("/access-denied");
        };
    }
}


