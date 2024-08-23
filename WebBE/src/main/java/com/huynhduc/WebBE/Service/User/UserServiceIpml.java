package com.huynhduc.WebBE.Service.User;

import com.huynhduc.WebBE.Dao.RoleRepository;
import com.huynhduc.WebBE.Dao.UserRepository;
import com.huynhduc.WebBE.Entity.Notify;
import com.huynhduc.WebBE.Entity.Role;
import com.huynhduc.WebBE.Entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import java.util.Collection;
import java.util.stream.Collectors;

@Service
public class UserServiceIpml implements UserService{

    private UserRepository userRepository;

    private RoleRepository roleRepository;

    @Autowired
    public UserServiceIpml(UserRepository userRepository, RoleRepository roleRepository) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
    }

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
}
