package com.finance.tracker.auth;
import com.finance.tracker.security.*; import com.finance.tracker.user.*; import jakarta.validation.Valid; import jakarta.validation.constraints.*; import org.springframework.http.*; import org.springframework.security.authentication.*; import org.springframework.security.crypto.password.PasswordEncoder; import org.springframework.web.bind.annotation.*;
@RestController @RequestMapping("/api/auth") public class AuthController {
 private final UserRepository users;private final PasswordEncoder encoder;private final AuthenticationManager manager;private final JwtService jwt;
 public AuthController(UserRepository users,PasswordEncoder encoder,AuthenticationManager manager,JwtService jwt){this.users=users;this.encoder=encoder;this.manager=manager;this.jwt=jwt;}
 @PostMapping("/register") @ResponseStatus(HttpStatus.CREATED) public AuthResponse register(@Valid @RequestBody RegisterRequest r){if(users.existsByUsername(r.username())||users.existsByEmail(r.email()))throw new IllegalArgumentException("Username or email is already in use");User u=new User();u.setUsername(r.username());u.setEmail(r.email());u.setPassword(encoder.encode(r.password()));u=users.save(u);return response(new UserPrincipal(u.getId(),u.getUsername(),u.getPassword()));}
 @PostMapping("/login") public AuthResponse login(@Valid @RequestBody LoginRequest r){var a=manager.authenticate(new UsernamePasswordAuthenticationToken(r.username(),r.password()));return response((UserPrincipal)a.getPrincipal());}
 private AuthResponse response(UserPrincipal p){return new AuthResponse(jwt.generateToken(p),p.id(),p.username());}
 public record RegisterRequest(@NotBlank @Size(min=3,max=50) String username,@NotBlank @Email String email,@NotBlank @Size(min=8,max=100) String password){} public record LoginRequest(@NotBlank String username,@NotBlank String password){} public record AuthResponse(String token,Long userId,String username){}
}
