package com.finance.tracker.user;
import jakarta.persistence.*;
import java.time.Instant;
@Entity @Table(name="users", uniqueConstraints={@UniqueConstraint(columnNames="username"), @UniqueConstraint(columnNames="email")})
public class User {
 @Id @GeneratedValue(strategy=GenerationType.IDENTITY) private Long id;
 @Column(nullable=false, length=50) private String username;
 @Column(nullable=false, length=120) private String email;
 @Column(nullable=false) private String password;
 @Column(nullable=false, updatable=false) private Instant createdAt=Instant.now();
 public Long getId(){return id;} public String getUsername(){return username;} public void setUsername(String v){username=v;} public String getEmail(){return email;} public void setEmail(String v){email=v;} public String getPassword(){return password;} public void setPassword(String v){password=v;}
}
