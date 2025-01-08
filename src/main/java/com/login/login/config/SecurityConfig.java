package com.login.login.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration // annotation i Spring Framework som används för att indikera att en klass delarar en eller flera @Bean-metoder
@EnableWebSecurity // annotation i Spring Security som används för att aktivera webb säkerhetstöd. 
public class SecurityConfig {

    @Bean // anoterar med bean så att det blir ett objekt att jobba med 
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {//Http objktet använder vi för att sätta upp konfigation för vilka request som kommer in och vilka säkerhet som krävs när det kommer in
        http
        .authorizeRequests((request) -> request
            .requestMatchers("/home").permitAll() // tillåter åtkomst åt alla
            .requestMatchers("/register").permitAll() // tillåter åtkomst åt alla
            .requestMatchers("/login").permitAll() // tillåter åtkomst åt alla
            .requestMatchers("/images/**").permitAll() // tillåter åtkomst åt alla
            .anyRequest().authenticated() // kräver inloggning
        )
        
        .formLogin(form -> form
            .loginPage("/login")
            .failureUrl("/login-error.html")
            .permitAll()) 

        .httpBasic(Customizer.withDefaults()); // vad sker om man misslyckas med att loggas in, då kommer den hit ist. kommer upp som en promt på webbläsaren. 

        return http.build();

    } 
    
}
