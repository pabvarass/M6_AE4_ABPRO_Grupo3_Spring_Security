package com.skillnest.m6.seguridad.service;

import com.skillnest.m6.seguridad.model.Usuario;
import com.skillnest.m6.seguridad.repository.UsuarioRepository;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class JpaUserDetailsService implements UserDetailsService {

  private final UsuarioRepository repo;

  public JpaUserDetailsService(UsuarioRepository repo) {
    this.repo = repo;
  }

  @Override
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    Usuario u = repo.findByUsername(username)
        .orElseThrow(() -> new UsernameNotFoundException("Usuario no encontrado: " + username));

    return User.withUsername(u.getUsername())
        .password(u.getPassword())
        .roles(u.getRole())
        .disabled(!u.isEnabled())
        .build();
  }
}
