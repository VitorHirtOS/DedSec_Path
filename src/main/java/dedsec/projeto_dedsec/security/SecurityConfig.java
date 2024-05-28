package dedsec.projeto_dedsec.security;

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
                .csrf(csrf -> csrf.disable()) // Desativa a proteção CSRF
                .authorizeHttpRequests(authorize -> authorize
                        .requestMatchers("/","/home", "/login", "/form", "/submitForm", "/css/**", "/image/**").permitAll() // Permite acesso a essas rotas
                        .anyRequest().authenticated()
                )
                .formLogin(form -> form
                        .loginPage("/login") // Especifica a página de login
                        .permitAll()
                )
                .logout(logout -> logout
                        .permitAll()
                );
        return http.build();
    }
}
