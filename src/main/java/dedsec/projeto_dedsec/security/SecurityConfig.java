package dedsec.projeto_dedsec.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf(csrf -> csrf.disable()) // Desativa a proteção CSRF
                .authorizeHttpRequests(authorize -> authorize
                        .requestMatchers("/", "/home", "/css/**", "/js/**", "/image/**").permitAll() // Permite acesso a essas rotas
                        .anyRequest().authenticated()
                )
                .formLogin(form -> form
                        .loginPage("/") // Especifica a página de login personalizada
                        .permitAll()
                        .defaultSuccessUrl("/menuLogin/index", true) // Página para redirecionar após login bem-sucedido
                )
                .logout(logout -> logout
                        .permitAll()
                );
        return http.build();
    }
}
