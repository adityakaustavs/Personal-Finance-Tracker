package com.finance.tracker.security;
import java.util.Collection; import java.util.List; import org.springframework.security.core.GrantedAuthority; import org.springframework.security.core.userdetails.UserDetails;
public record UserPrincipal(Long id, String username, String password) implements UserDetails { public Collection<? extends GrantedAuthority> getAuthorities(){return List.of();} public boolean isAccountNonExpired(){return true;} public boolean isAccountNonLocked(){return true;} public boolean isCredentialsNonExpired(){return true;} public boolean isEnabled(){return true;} }
