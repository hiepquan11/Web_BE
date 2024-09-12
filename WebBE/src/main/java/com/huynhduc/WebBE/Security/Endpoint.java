package com.huynhduc.WebBE.Security;

public class Endpoint {
    public static final String front_end_host = "http://localhost:3000";
    public static final String[] PUBLIC_GET_ENDPOINTS = {
            "/product",
            "/product/**",
            "/image",
            "/category",
            "/category/**",
            "/image/**",
            "/user/search/existsByUserName",
            "/user/search/existsByEmail",
            "/userAccount/activate",


    };

    public static final String[] PUBLIC_POST_ENDPOINTS = {
            "/userAccount/register",
            "/userAccount/login",
            "/api/upload",
    };

    public static final String[] ADMIN_GET_ENDPOINTS = {
            "/user",
            "/user/**"
    };

    public static final String[] ADMIN_POST_ENDPOINTS = {
            "/product/**",

    };
 }
