package com.academt.progetto_giorno_12;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
@EnableWebSecurity
public class SecurityConfig
{
    @Bean
    public SecurityFilterChain filterChain (HttpSecurity http) throws Exception
    {
        http
                // Disabilita il CSRF
                .csrf(csrf -> csrf.disable())
                .authorizeHttpRequests(auth -> auth
                        // Permetti richieste GET a tutti gli utenti autenticati
                        .requestMatchers(HttpMethod.GET, "/*").hasAnyRole("admin", "user")

                        // Permette richieste GET su un URL specifico, in questo caso "/api/studenti"
                        //.requestMatchers(HttpMethod.GET, "/api/studenti").permitAll()

                        // Permette richieste POST, PUT e DELETE solo al ruolo admin
                        .requestMatchers(HttpMethod.POST, "/*").hasRole("admin")
                        .requestMatchers(HttpMethod.PUT, "/*").hasRole("admin")
                        .requestMatchers(HttpMethod.DELETE, "/*").hasRole("admin")
                        // Tutto il resto richiede autenticazione
                        .anyRequest().authenticated()
                )
                .httpBasic(withDefaults());
        return http.build();
    }

    @Bean
    public InMemoryUserDetailsManager userDetailsManager()
    {
        /*
            Impostazoine nuovo utente:
            username = "admin"
            password = "admin123"
            ruolo = "admin"
         */
        UserDetails admin = User.builder()
                .username("admin")
                .password("{noop}admin123")
                .roles("admin")
                .build();

        UserDetails user = User.builder()
                .username("user")
                .password("{noop}user123")
                .roles("user")
                .build();

        return new InMemoryUserDetailsManager(admin, user);
    }
}
