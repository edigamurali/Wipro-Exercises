package com.wipro.usermgmtv2.service.impl;

import com.wipro.usermgmtv2.entity.User;
import com.wipro.usermgmtv2.model.Token;
import com.wipro.usermgmtv2.repo.UserRepo;
import com.wipro.usermgmtv2.service.UserService;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.Key;
import java.util.Date;
import java.util.List;

@Service
public class USerServiceImpl implements UserService {

    @Autowired
    private UserRepo userRepo;

    private static final String SECRET = "mySecretKeymySecretKeymySecretKeymySecretKey";
    private final Key key = Keys.hmacShaKeyFor(SECRET.getBytes());

    @Override
    public List<User> findAll() {
        return userRepo.findAll();
    }

    @Override
    public User findById(int id) {
        return userRepo.findById(id).orElse(null);
    }

    @Override
    public void save(User user) {
        userRepo.save(user);
    }

    @Override
    public void deleteById(int id) {
        userRepo.deleteById(id);
    }

    @Override
    public Token login(User user) {
        User userData = userRepo.findByEmailAndPassWord(user.getEmail(), user.getPassWord());
        if (userData != null) {
            String jwt = generateJWT(userData.getEmail());
            return new Token("Bearer " + jwt);
        }
        return null;
    }

    private String generateJWT(String username) {
        return Jwts.builder()
                .setId("jwtExample")
                .setSubject(username)
                .claim("authorities", List.of("ROLE_USER")) // simple role
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60)) // 1 hr
                .signWith(key)
                .compact();
    }
}
