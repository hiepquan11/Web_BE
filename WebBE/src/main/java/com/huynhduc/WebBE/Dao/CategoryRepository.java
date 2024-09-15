package com.huynhduc.WebBE.Dao;

import com.huynhduc.WebBE.Entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

import java.util.List;

@RepositoryRestResource(path = "category")
public interface CategoryRepository extends JpaRepository<Category, Integer> {
    public List<Category> findByCategoryID(int categoryID);
}
