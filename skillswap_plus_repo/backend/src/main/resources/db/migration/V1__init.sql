CREATE TABLE users (
  id BIGSERIAL PRIMARY KEY,
  email VARCHAR(255) UNIQUE NOT NULL,
  password VARCHAR(255) NOT NULL,
  full_name VARCHAR(255),
  avatar_url VARCHAR(512),
  xp INT DEFAULT 0,
  level INT DEFAULT 1,
  language VARCHAR(10),
  location_lat DOUBLE PRECISION,
  location_lon DOUBLE PRECISION,
  roles VARCHAR(255) DEFAULT 'USER',
  created_at TIMESTAMP DEFAULT now(),
  updated_at TIMESTAMP DEFAULT now()
);
