package com.huynhduc.WebBE.Security;

import com.huynhduc.WebBE.Service.User.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfiguration {
    public BCryptPasswordEncoder passwordEncoder (){
        return new BCryptPasswordEncoder();
    }

    @Bean
    @Autowired
    public DaoAuthenticationProvider authenticationProvider (UserService userService){
        DaoAuthenticationProvider dap = new DaoAuthenticationProvider();
        dap.setUserDetailsService(userService);
        dap.setPasswordEncoder(passwordEncoder());
        return dap;
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests(
                configurer->configurer
                        .requestMatchers(HttpMethod.GET,  "/product").permitAll()
                        .requestMatchers(HttpMethod.GET,"/product/**").permitAll()
                        .requestMatchers(HttpMethod.GET, "/image").permitAll()
                        .requestMatchers(HttpMethod.GET, "/image/**").permitAll()
                        .requestMatchers(HttpMethod.GET,  "/user").hasAuthority("ADMIN")
                        .requestMatchers(HttpMethod.POST,  "/userAccount/register").permitAll()
        );
        http.httpBasic(Customizer.withDefaults());
        http.csrf(csrf->csrf.disable());
        return http.build();
    }
}
