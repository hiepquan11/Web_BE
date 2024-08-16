package com.huynhduc.WebBE.Service;

import com.huynhduc.WebBE.Dao.UserRepository;
import com.huynhduc.WebBE.Entity.Notify;
import com.huynhduc.WebBE.Entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public ResponseEntity<?> register(User user){
        // check username
        if(userRepository.existsByUserName(user.getUserName())){
            return ResponseEntity.badRequest().body(new Notify("Username is exist"));
        }
        // check email
        if(userRepository.existsByEmail(user.getEmail())){
            return ResponseEntity.badRequest().body(new Notify("Email is exist"));
        }
        // save user in database
        User newUser = userRepository.save(user);
        return ResponseEntity.ok("Register Successful");
    }
}
