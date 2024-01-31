package com.huynhduc.WebBE.Dao;

import com.huynhduc.WebBE.Entity.FavouriteProduct;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FavouriteProductRepository extends JpaRepository<FavouriteProduct, Integer> {
}
