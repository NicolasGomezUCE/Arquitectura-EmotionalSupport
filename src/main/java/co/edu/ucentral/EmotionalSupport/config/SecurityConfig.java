package co.edu.ucentral.EmotionalSupport.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf(csrf -> csrf.disable()) // Disable CSRF for stateless APIs
                .authorizeHttpRequests(authorize -> authorize
                        // For initial testing, allow all.
                        // In production, you'd secure based on authentication:
                        // .requestMatchers("/comunidad/publicar").authenticated()
                        // .requestMatchers("/comunidad/**", "/recursos/emocionales").authenticated()
                        .anyRequest().permitAll() // Temporarily allow all requests
                );
        return http.build();
    }
}