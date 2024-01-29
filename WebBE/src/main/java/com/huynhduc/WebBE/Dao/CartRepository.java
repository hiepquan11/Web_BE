package com.huynhduc.WebBE.Dao;

import com.huynhduc.WebBE.Entity.Cart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

@RepositoryRestResource(path = "cart")
public interface CartRepository extends JpaRepository<Cart, Integer> {
}
