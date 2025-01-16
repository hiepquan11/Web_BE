package com.huynhduc.WebBE.Service.Cart;

import com.huynhduc.WebBE.DTO.Response.CartItem;
import com.huynhduc.WebBE.DTO.Response.CartResponse;
import com.huynhduc.WebBE.Dao.CartRepository;
import com.huynhduc.WebBE.Dao.ProductRepository;
import com.huynhduc.WebBE.Dao.UserRepository;
import com.huynhduc.WebBE.Entity.Cart;
import com.huynhduc.WebBE.Entity.Product;
import com.huynhduc.WebBE.Entity.User;
import com.huynhduc.WebBE.Service.Jwt.JwtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CartImpl implements CartService {

    @Autowired
    private  ProductRepository productRepository;
    @Autowired
    private CartRepository cart;
    @Autowired
    private JwtService jwtService;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private CartRepository cartRepository;


    @Override
    public CartResponse addToCart(CartItem cartItem, String token) {
        token = token.substring(7);
        String userName = jwtService.extractUsername(token);
        if(userName == null){
            throw new Error("Invalid token");
        }
        User user = userRepository.findByUserName(userName);
        if(user == null){
            throw new Error("Invalid user");
        }

        if(!checkProduct(cartItem.getProductId())){
            throw new Error("Product is not found: " + cartItem.getProductId());
        }
        Product product = productRepository.findProductByProductID(cartItem.getProductId());
        Cart cart = new Cart();
        cart.setProduct(product);
        cart.setQuantity(cartItem.getQuantity());
        cart.setPrice(product.getPrice());
        cart.setTotalPrice(product.getPrice()*cartItem.getQuantity());
        cart.setUser(user);

        cartRepository.save(cart);

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
    public List<CartResponse> getAllProductsInCart(String token) {
        token = token.substring(7);
        int userId = jwtService.extractUserId(token);
        User user = userRepository.findByID(userId);
        if(userId == 0){
            throw new Error("Invalid user");
        }
        List<Cart> carts = cartRepository.findCartByUser(user);
        List<CartResponse> cartResponses = new ArrayList<>();
        for(Cart cart : carts){
            CartResponse response = new CartResponse();
            response.setPrice(cart.getProduct().getPrice());
            response.setProductName(cart.getProduct().getName());
            response.setProductQuantity(cart.getQuantity());
            response.setTotalPrice(cart.getProduct().getPrice() * cart.getQuantity());

            cartResponses.add(response);
        }

        return cartResponses;
    }

    private boolean checkProduct(int productId){
        return productRepository.existsProductByProductID(productId);
    }
}
