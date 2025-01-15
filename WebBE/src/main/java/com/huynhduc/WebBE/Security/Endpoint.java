package com.huynhduc.WebBE.Security;

public class Endpoint {
    public static final String front_end_host = "http://localhost:3000";
    public static final String[] PUBLIC_GET_ENDPOINTS = {
            "/product",
            "/product/**",
            "/category",
            "/category/**",
            "/image",
            "/category",
            "/category/**",
            "/image/**",
            "/user/search/existsByUserName",
            "/user/search/existsByEmail",
            "/userAccount/activate",
            "/api/product/updateProduct",
            "/api/product"
    };

    public static final String[] PUBLIC_POST_ENDPOINTS = {
            "/userAccount/register",
            "/userAccount/login",
            "/api/cart/add"
    };
    public static final String[] PUBLIC_PUT_ENDPOINTS = {
            "/api/updateProduct",
    };

    public static final String[] ADMIN_GET_ENDPOINTS = {
            "/user",
            "/user/**",
    };

    public static final String[] ADMIN_POST_ENDPOINTS = {
            "/api/addProduct",
            "/api/upload"
    };
 }
