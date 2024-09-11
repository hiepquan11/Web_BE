package com.huynhduc.WebBE.Security;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
public class JwtResponse {
    private final String Jwt;

//    public JwtResponse(String jwt) {
//        Jwt = jwt;
//    }

    public String getJwt(){
        return Jwt;
    }
}
