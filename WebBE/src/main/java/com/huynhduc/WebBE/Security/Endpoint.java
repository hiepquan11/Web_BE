package com.huynhduc.WebBE.Security;

public class Endpoint {
    public static final String[] PUBLIC_GET_ENDPOINTS = {
            "/product",
            "/product/**",
            "/image",
            "image/**"
    };
}
