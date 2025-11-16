package com.skillnest.m6.seguridad.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "usuarios")
public class Usuario {

  @Id
  private String username;

  @Column(nullable = false)
  private String password;

  @Column(nullable = false)
  private String role; // USER o ADMIN

  @Column(nullable = false)
  private boolean enabled = true;

  public Usuario() {}

  public Usuario(String username, String password, String role, boolean enabled) {
    this.username = username;
    this.password = password;
    this.role = role;
    this.enabled = enabled;
  }

  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public String getRole() {
    return role;
  }

  public void setRole(String role) {
    this.role = role;
  }

  public boolean isEnabled() {
    return enabled;
  }

  public void setEnabled(boolean enabled) {
    this.enabled = enabled;
  }
}
