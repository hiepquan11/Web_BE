package com.huynhduc.WebBE.Service.Cart;

import com.huynhduc.WebBE.Controller.CartController;
import com.huynhduc.WebBE.DTO.Response.CartItem;
import com.huynhduc.WebBE.DTO.Response.CartResponse;
import com.huynhduc.WebBE.Dao.ProductRepository;
import com.huynhduc.WebBE.Entity.Cart;
import com.huynhduc.WebBE.Entity.Product;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CartImpl implements CartService {
    private final ProductRepository productRepository;
    private final CartController cart;

    public CartImpl(ProductRepository productRepository, CartController cart) {
        this.productRepository = productRepository;
        this.cart = cart;
    }

    @Override
    public CartResponse addToCart(CartItem cartItem) {
        if(!checkProduct(cartItem.getProductId())){
            throw new IllegalArgumentException("Product is not found: " + cartItem.getProductId());
        }
        Product product = productRepository.findProductByProductID(cartItem.getProductId());
        Cart cart = new Cart();
        cart.setProduct(product);
        cart.setQuantity(cartItem.getQuantity());

        CartResponse response = new CartResponse();
        response.setPrice(cart.getProduct().getPrice());
        response.setProductName(cart.getProduct().getName());
        response.setProductQuantity(cart.getQuantity());
        response.setTotalPrice(cart.getProduct().getPrice() * cart.getQuantity());

        return response;
    }

    @Override
    public Product removeFromCart(int productId) {
        return null;
    }

    @Override
    public Product updateProductQuantity(int productId, int quantity) {
        return null;
    }

    @Override
    public List<Product> getAllProductsInCart() {
        return List.of();
    }

    private boolean checkProduct(int productId){
        return productRepository.existsProductByProductID(productId);
    }
}
