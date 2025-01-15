package com.huynhduc.WebBE.Service.Cart;

import com.huynhduc.WebBE.DTO.Response.CartItem;
import com.huynhduc.WebBE.DTO.Response.CartResponse;
import com.huynhduc.WebBE.Entity.Cart;
import com.huynhduc.WebBE.Entity.Product;

import java.util.List;

public interface CartService {
    CartResponse addToCart(CartItem cartItem);
    Product removeFromCart(int productId);
    Product updateProductQuantity(int productId, int quantity);
    List<Product> getAllProductsInCart();
}
