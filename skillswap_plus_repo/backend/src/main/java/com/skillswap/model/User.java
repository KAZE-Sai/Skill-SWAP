package com.skillswap.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.Instant;

@Entity
@Table(name = "users")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User {
  @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(nullable=false, unique=true)
  private String email;

  @Column(nullable=false)
  private String password;

  private String fullName;
  private String avatarUrl;
  private Integer xp = 0;
  private Integer level = 1;
  private String language;
  private Double locationLat;
  private Double locationLon;
  private String roles = "USER";
  private Instant createdAt = Instant.now();
}
