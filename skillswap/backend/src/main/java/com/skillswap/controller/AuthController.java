package com.skillswap.controller;

import com.skillswap.model.User;
import com.skillswap.repository.UserRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;
import java.util.Map;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin
public class AuthController {
  private final UserRepository userRepository;
  private final BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

  public AuthController(UserRepository userRepository) { this.userRepository = userRepository; }

  @PostMapping("/register")
  public ResponseEntity<?> register(@RequestBody Map<String,String> body) {
    String email = body.get("email"), password = body.get("password"), fullName = body.get("fullName");
    if (userRepository.findByEmail(email).isPresent()) return ResponseEntity.badRequest().body(Map.of("error","Email in use"));
    User user = User.builder().email(email).password(passwordEncoder.encode(password)).fullName(fullName).avatarUrl("https://api.dicebear.com/6.x/identicon/svg?seed="+email).build();
    userRepository.save(user);
    return ResponseEntity.ok(Map.of("ok", true));
  }
}
