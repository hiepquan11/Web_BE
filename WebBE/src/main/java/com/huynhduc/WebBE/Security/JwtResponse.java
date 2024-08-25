package com.huynhduc.WebBE.Security;

public class JwtResponse {
    private final String Jwt;

    public JwtResponse(String jwt) {
        Jwt = jwt;
    }

    public String getJwt(){
        return Jwt;
    }
}
