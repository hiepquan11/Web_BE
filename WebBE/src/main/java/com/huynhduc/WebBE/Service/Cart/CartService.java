package com.huynhduc.WebBE.Service.Cart;

import com.huynhduc.WebBE.DTO.Response.CartItem;
import com.huynhduc.WebBE.DTO.Response.CartResponse;
import com.huynhduc.WebBE.Entity.Cart;
import com.huynhduc.WebBE.Entity.Product;

import java.util.List;

public interface CartService {
    CartResponse addToCart(CartItem cartItem, String token);
    void removeFromCart(int productId, String token);
    Cart updateProductQuantity(int cartId);
    List<CartResponse> getAllProductsInCart(String token);
}
