package com.huynhduc.WebBE.Controller;

import com.huynhduc.WebBE.Entity.User;
import com.huynhduc.WebBE.Security.JwtResponse;
import com.huynhduc.WebBE.Security.LoginRequest;
import com.huynhduc.WebBE.Service.Jwt.JwtService;
import com.huynhduc.WebBE.Service.User.UserServiceIpml;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/userAccount")
public class UserController {
    @Autowired
    private UserServiceIpml userServiceIpml;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtService jwtService;

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

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest loginRequest){

        try {
            Authentication authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(loginRequest.getUserName(), loginRequest.getPassword())
            );
            if(authentication.isAuthenticated()){
                final String jwt = jwtService.generateToken(loginRequest.getUserName());
                return ResponseEntity.ok(new JwtResponse(jwt));
            }
        } catch (AuthenticationException e){
            return ResponseEntity.badRequest().body("Tài khoản hoặc mật khẩu không chính xác");
        }
        return ResponseEntity.badRequest().body("Xác thực không thành công");
    }
}
