package com.huynhduc.WebBE.Service.User;

import com.huynhduc.WebBE.Entity.User;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService {
    public ResponseEntity<?> register(User user);
    public User findByUsername(String username);
}
