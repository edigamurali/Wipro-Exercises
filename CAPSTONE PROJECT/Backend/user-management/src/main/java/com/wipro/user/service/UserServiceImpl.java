package com.wipro.user.service;

import java.security.Key;
import java.util.Base64;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wipro.user.dto.Token;
import com.wipro.user.entity.User;
import com.wipro.user.repo.UserRepo;
import com.wipro.user.util.AppConstant;
import com.wipro.user.util.EncryptUtil;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepo userRepo;

    @Override
    public User register(User user) {
        User existing = userRepo.findByEmail(user.getEmail());
        if (existing != null) {
            throw new RuntimeException("Email already registered");
        }

        String salt = EncryptUtil.generateSalt();
        String hashed = EncryptUtil.getEncryptedPassword(user.getPassword(), salt);
        user.setSalt(salt);
        user.setPassword(hashed);

        if (user.getRole() == null || user.getRole().isEmpty()) {
            user.setRole("ROLE_USER");
        }

        return userRepo.save(user);
    }

    @Override
    public Token login(User user) {
        User dbUser = userRepo.findByEmail(user.getEmail());
        if (dbUser != null && EncryptUtil.verifyUserPassword(user.getPassword(), dbUser.getPassword(), dbUser.getSalt())) {
            String jwt = generateJWTToken(dbUser);
            return new Token(jwt);
        } else {
            throw new RuntimeException("Invalid credentials");
        }
    }

    private String generateJWTToken(User user) {
        Key key = Keys.hmacShaKeyFor(Base64.getDecoder().decode(AppConstant.SECRET));

        System.out.println("Generating token for user: " + user.getEmail() + " with role: " + user.getRole());

        return Jwts.builder()
                .setSubject(user.getEmail())
                .claim("roles", List.of(user.getRole()))
                .claim("email", user.getEmail())
                .claim("userId", String.valueOf(user.getId()))
                .claim("name", user.getName())
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + 3600000)) // 1 hour
                .signWith(key, SignatureAlgorithm.HS512)
                .compact();
    }

    @Override
    public List<User> findAll() {
        return userRepo.findAll();
    }

    @Override
    public User findById(int id) {
        Optional<User> user = userRepo.findById(id);
        if (user.isEmpty()) {
            throw new RuntimeException("User not found with id: " + id);
        }
        return user.get();
    }

    @Override
    public void save(User user) {
        userRepo.save(user);
    }

    @Override
    public void deleteById(int id) {
        if (!userRepo.existsById(id)) {
            throw new RuntimeException("User not found with id: " + id);
        }
        userRepo.deleteById(id);
    }

    @Override
    public User updateProfileByEmail(String email, User payload) {
        User dbUser = userRepo.findByEmail(email);
        if (dbUser == null) {
            throw new RuntimeException("User not found");
        }
        if (payload.getName() != null) dbUser.setName(payload.getName());
        if (payload.getEmail() != null) dbUser.setEmail(payload.getEmail());
        if (payload.getPassword() != null && !payload.getPassword().isBlank()) {
            String newSalt = EncryptUtil.generateSalt();
            String newHashed = EncryptUtil.getEncryptedPassword(payload.getPassword(), newSalt);
            dbUser.setSalt(newSalt);
            dbUser.setPassword(newHashed);
        }
        return userRepo.save(dbUser);
    }
}
