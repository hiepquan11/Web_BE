package com.huynhduc.WebBE.Dao;

import com.huynhduc.WebBE.Entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@RepositoryRestResource(path = "product")
public interface ProductRepository extends JpaRepository<Product, Integer> {
    List<Product> findByNameContaining(@RequestParam("name") String name);

    @Query("SELECT pd FROM Product pd JOIN FETCH pd.listImage")
    List<Product> findAllWithImages();
}
