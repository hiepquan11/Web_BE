package com.huynhduc.WebBE.Controller;

import com.huynhduc.WebBE.Entity.User;
import com.huynhduc.WebBE.Service.User.UserServiceIpml;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/userAccount")
public class UserController {
    @Autowired
    private UserServiceIpml userServiceIpml;

    @PostMapping("/register")
    public ResponseEntity<?> register(@Validated @RequestBody User user){
        ResponseEntity<?> response = userServiceIpml.register(user);
        return response;
    }

    @GetMapping("/activate")
    public ResponseEntity<?> activationAccount(@RequestParam String email, @RequestParam String activationCode){
        ResponseEntity<?> response = userServiceIpml.activationAccount(email, activationCode);
        return response;
    }
}
