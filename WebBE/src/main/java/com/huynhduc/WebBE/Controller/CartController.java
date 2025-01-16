package com.huynhduc.WebBE.Controller;

import com.huynhduc.WebBE.DTO.Response.CartItem;
import com.huynhduc.WebBE.DTO.Response.CartResponse;
import com.huynhduc.WebBE.Entity.Cart;
import com.huynhduc.WebBE.Entity.Notify;
import com.huynhduc.WebBE.Service.Cart.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cart")
public class CartController {
    @Autowired
    private CartService cartService;

    @GetMapping("/getAll")
    public ResponseEntity<Object> getCart(@RequestHeader("Authorization") String token){
        List<CartResponse> carts = cartService.getAllProductsInCart(token);
        if(carts == null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new Notify("No product in your cart"));
        }
        return ResponseEntity.ok(carts);
    }
    @PostMapping("/add")
    public ResponseEntity<Object> addToCart(@RequestBody CartItem cartItem,
                                            @RequestHeader("Authorization") String token) {
        return ResponseEntity.ok(cartService.addToCart(cartItem, token));
    }
}
