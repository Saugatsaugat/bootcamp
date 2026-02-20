package com.saugat.bootcamp.service;

import com.saugat.bootcamp.exceptions.ResourceNotFoundException;
import com.saugat.bootcamp.model.User;
import com.saugat.bootcamp.repository.UserRepository;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Service;

import java.nio.charset.StandardCharsets;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Date;

@Service
public class JwtService {
    private static final String SECRET = "CHANGE_ME_TO_A_LONG_RANDOM_SECRET_AT_LEAST_32_CHARS_LONG_123456";

    private final UserRepository userRepository;

    public JwtService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public String generateToken(User user){
       User existingUser =  userRepository.findUserByEmail(user.getEmail());
//       if(existingUser == null){
//           throw new ResourceNotFoundException("User not found");
//       }
        return Jwts.builder()
                .setSubject(user.getEmail())
                .setIssuedAt(Date.from(Instant.now()))
                .setExpiration(Date.from(Instant.now().plus(1, ChronoUnit.DAYS)))
                .signWith(Keys.hmacShaKeyFor(SECRET.getBytes(StandardCharsets.UTF_8)), SignatureAlgorithm.HS256)
                .compact();
    }
}
