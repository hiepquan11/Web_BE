package com.huynhduc.WebBE.Dao;

import com.huynhduc.WebBE.Entity.Cart;
import com.huynhduc.WebBE.Entity.Product;
import com.huynhduc.WebBE.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

import java.util.List;

@RepositoryRestResource(path = "cart")
public interface CartRepository extends JpaRepository<Cart, Integer> {
    List<Cart> findCartByUser(User user);
    Cart findCartByUserAndAndProduct(User user, Product product);
//    Cart findCartByUserIDAndProductID(int userID, int productID);
}
