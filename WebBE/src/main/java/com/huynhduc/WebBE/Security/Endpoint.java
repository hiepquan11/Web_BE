package com.huynhduc.WebBE.Security;

public class Endpoint {
    public static final String[] PUBLIC_GET_ENDPOINTS = {
            "/product",
            "/product/**",
            "/image",
            "/image/**",
            "/user/search/existsByUserName",
            "/user/search/existsByEmail",
            "/userAccount/activate"
    };

    public static final String[] PUBLIC_POST_ENDPOINTS = {
            "/userAccount/register",
    };

    public static final String[] ADMIN_GET_ENDPOINTS = {
            "/user",
            "/user/**"
    };
}
