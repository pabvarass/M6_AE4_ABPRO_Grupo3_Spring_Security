package com.skillnest.m6.seguridad.config;

import com.skillnest.m6.seguridad.model.Usuario;
import com.skillnest.m6.seguridad.repository.UsuarioRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

  @Bean
  public PasswordEncoder passwordEncoder() {
    return new BCryptPasswordEncoder();
  }

  @Bean
  public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
    http
      .authorizeHttpRequests(auth -> auth
        .requestMatchers("/", "/login", "/css/**", "/js/**", "/images/**").permitAll()
        .requestMatchers("/admin/**").hasRole("ADMIN")
        .requestMatchers("/perfil/**").authenticated()
        .anyRequest().authenticated()
      )
      .formLogin(login -> login
        .loginPage("/login")
        .loginProcessingUrl("/login")
        .defaultSuccessUrl("/panel", true)
        .permitAll()
      )
      .logout(logout -> logout
        .logoutUrl("/logout")
        .logoutSuccessUrl("/login?logout")
        .permitAll()
      );

    return http.build();
  }

  @Bean
  public CommandLineRunner seedUsers(UsuarioRepository repo, PasswordEncoder encoder) {
    return args -> {
      if (repo.count() == 0) {
        repo.save(new Usuario("admin", encoder.encode("admin123"), "ADMIN", true));
        repo.save(new Usuario("pepe",  encoder.encode("pepe123"),  "USER",  true));
      }
    };
  }
}
