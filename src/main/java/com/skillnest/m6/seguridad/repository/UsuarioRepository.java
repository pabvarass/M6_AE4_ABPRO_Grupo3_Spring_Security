package com.skillnest.m6.seguridad.repository;

import com.skillnest.m6.seguridad.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UsuarioRepository extends JpaRepository<Usuario, String> {
  Optional<Usuario> findByUsername(String username);
}
