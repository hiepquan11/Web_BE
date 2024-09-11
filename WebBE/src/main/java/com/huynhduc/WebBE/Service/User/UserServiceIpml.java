package com.huynhduc.WebBE.Service.User;

import com.huynhduc.WebBE.Dao.RoleRepository;
import com.huynhduc.WebBE.Dao.UserRepository;
import com.huynhduc.WebBE.Entity.Notify;
import com.huynhduc.WebBE.Entity.Role;
import com.huynhduc.WebBE.Entity.User;
import com.huynhduc.WebBE.Service.Email.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import java.util.Collection;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class UserServiceIpml implements UserService{

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private EmailService emailService;

    @Autowired
    @Lazy
    private BCryptPasswordEncoder passwordEncoder;



    @Override
    public ResponseEntity<?> register(User user) {
        // check username
        if(userRepository.existsByUserName(user.getUserName())){
            return ResponseEntity.badRequest().body(new Notify("Username is exist"));
        }
        // check email
        if(userRepository.existsByEmail(user.getEmail())){
            return ResponseEntity.badRequest().body(new Notify("Email is exist"));
        }

        // encrypt password
        String encodedPassword = passwordEncoder.encode(user.getPassword());
        user.setPassword(encodedPassword);

        // activate
        user.setActivationCode(createActivationCode());
        user.setEnabled(false);

        // send email
        sendEmail(user.getEmail(), user.getActivationCode());

        // save user in database
        User newUser = userRepository.save(user);
        return ResponseEntity.ok("Register Successful");
    }

    @Override
    public User findByUsername(String username) {
        return userRepository.findByUserName(username);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUserName(username);
        if(user == null) {
            throw new UsernameNotFoundException("Account not found");
        }
        return new org.springframework.security.core.userdetails.User(user.getUserName(), user.getPassword(), rolesToAuthorities(user.getListRole()));
    }

    private Collection<? extends GrantedAuthority> rolesToAuthorities(Collection<Role> roles) {
        return roles.stream().map(role -> new SimpleGrantedAuthority(role.getRoleName())).collect(Collectors.toList());
    }

    public String createActivationCode(){
        return UUID.randomUUID().toString();
    }

    public void sendEmail(String email, String ActivationCode){
        String subject = "Kích hoạt tài khoản";
        String url = "http://localhost:3000/activate/"+email+ "/"+ActivationCode;
        String text = "Sử dụng mã này để kích hoạt tài khoản";
        text += "<br/> <a href="+url+">"+url+"</a>";
        emailService.SendMessage("tahuynhduc09102000@gmail.com",email,subject,text);
    }

    public ResponseEntity<?> activationAccount(String email, String activationCode){
        User user = userRepository.findByEmail(email);

        if(user == null) {
            return ResponseEntity.badRequest().body(new Notify("Người dùng không tồn tại"));
        }

        if(user.getEnabled()){
            return ResponseEntity.badRequest().body(new Notify("Người dùng đã được kích hoạt"));
        }

        if(activationCode.equals(user.getActivationCode())){
            user.setEnabled(true);
            userRepository.save(user);
            return ResponseEntity.ok(new Notify("Kích hoạt tài khoản thành công"));
        } else {
            return ResponseEntity.badRequest().body(new Notify("Mã kích hoạt không chính xác"));
        }
    }
}
