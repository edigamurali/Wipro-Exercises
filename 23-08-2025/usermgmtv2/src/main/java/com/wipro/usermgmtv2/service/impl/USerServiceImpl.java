package com.wipro.usermgmtv2.service.impl;

import java.security.Key;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wipro.usermgmtv2.entity.User;
import com.wipro.usermgmtv2.model.Token;
import com.wipro.usermgmtv2.repo.UserRepo;
import com.wipro.usermgmtv2.service.UserService;
import com.wipro.usermgmtv2.util.EncryptUtil;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;

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
        if (user.getId() == 0) { // new user registration
            String encryptedPassword = EncryptUtil.getEncryptedPassword(user.getPassWord());
            user.setPassWord(encryptedPassword);
        } else {
            User existingUser = userRepo.findById(user.getId()).orElse(null);
            if (existingUser != null) {
                // if password changed
                if (!EncryptUtil.checkPassword(user.getPassWord(), existingUser.getPassWord())) {
                    String encryptedPassword = EncryptUtil.getEncryptedPassword(user.getPassWord());
                    user.setPassWord(encryptedPassword);
                } else {
                    // keep old hash
                    user.setPassWord(existingUser.getPassWord());
                }
            }
        }
        userRepo.save(user);
    }

    @Override
    public void deleteById(int id) {
        userRepo.deleteById(id);
    }

    @Override
    public Token login(User user) {
        User dbUser = userRepo.findByEmail(user.getEmail());
        if (dbUser == null) {
            return null;
        }

        // verify password with stored hash
        if (EncryptUtil.checkPassword(user.getPassWord(), dbUser.getPassWord())) {
            String jwt = generateJWT(dbUser.getEmail());
            return new Token("Bearer " + jwt);
        }
        return null;
    }

    private String generateJWT(String username) {
        return Jwts.builder()
                .setId("jwtExample")
                .setSubject(username)
                .claim("authorities", List.of("ROLE_USER"))
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60)) // 1 hr
                //.setExpiration(new Date(System.currentTimeMillis() + 1000 * 60)) // 1 min
                .signWith(key)
                .compact();
    }
}
