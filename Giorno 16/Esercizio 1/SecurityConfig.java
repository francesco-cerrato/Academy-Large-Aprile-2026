package com.academy.progetto_giorno_13.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import javax.sql.DataSource;

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
                        // Consenti l'accesso a h2-console
                        .requestMatchers("/h2-console/**").permitAll()
                        // Permetti richieste GET a tutti gli utenti autenticati
                        .requestMatchers(HttpMethod.GET, "/*").hasAnyRole("admin", "user")

                        // Permette richieste GET su un URL specifico, in questo caso "/api/studenti"
                        //.requestMatchers(HttpMethod.GET, "/api/studenti").permitAll()

                        // Permette richieste POST, PUT e DELETE solo al ruolo admin
                        .requestMatchers(HttpMethod.POST, "/**").hasRole("admin")
                        .requestMatchers(HttpMethod.PUT, "/**").hasRole("admin")
                        .requestMatchers(HttpMethod.DELETE, "/**").hasRole("admin")
                        // Tutto il resto richiede autenticazione
                        .anyRequest().authenticated()
                )
                .headers(headers -> headers.frameOptions(frame -> frame.sameOrigin())) // Necessario per h2
                .httpBasic(withDefaults());
        return http.build();
    }

    /*
        Questo Bean era utilizzato per gestire automaticamente utenti e ruoli nel DB
    @Bean
    public JdbcUserDetailsManager userDetailsManager(DataSource dataSource)
    {
        return new JdbcUserDetailsManager(dataSource);
    }
     */

    @Bean
    public JdbcUserDetailsManager userDetailsManager(DataSource dataSource)
    {
        JdbcUserDetailsManager myUserDetailsManager = new JdbcUserDetailsManager(dataSource);

        /*
            Configura la query SQL per recuperare i dati dell'utente durante il login.
            Spring si aspetta esattamente 3 colonne in questo ordine: username, password, enabled.
            Il "?" verrà sostituito automaticamente dallo username inserito nel form di login.
         */
        myUserDetailsManager
                .setUsersByUsernameQuery("select username, password, enabled " +
                        "from members where username=?");

        /*
            Configura la query SQL per recuperare i ruoli (authorities) dell'utente.
            Spring si aspetta 2 colonne: username e la stringa del ruolo (es. ROLE_admin).
         */
        myUserDetailsManager
                .setAuthoritiesByUsernameQuery("select username, authority from roles where username=?");

        return myUserDetailsManager;
    }

    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder()
    {
        /*
            Questo bean crea ed attua l'algoritmo BCrypt
            per criptare le password tramite hash
         */
        return new BCryptPasswordEncoder();
    }


    /*
    Questo @Bean InMemoryUserDetailsManager era utilizato per assegnare
    in memoria dell'app (non in memoria db) i ruoli degli utenti
    @Bean
    public InMemoryUserDetailsManager userDetailsManager()
    {
            // Impostazoine nuovo utente: username = "admin", password = "admin123", ruolo = "admin"

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
    }*/
}

