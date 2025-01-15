package com.huynhduc.WebBE.Controller;

import com.huynhduc.WebBE.DTO.Response.CartItem;
import com.huynhduc.WebBE.Service.Cart.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/cart")
public class CartController {
    @Autowired
    @Lazy
    private CartService cartService;

    @PostMapping("/add")
    public ResponseEntity<Object> addToCart(@RequestBody CartItem cartItem) {
        return ResponseEntity.ok(cartService.addToCart(cartItem));
    }
}
