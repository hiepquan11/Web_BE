package com.huynhduc.WebBE.Service;

import com.huynhduc.WebBE.Dao.ProductRepository;
import com.huynhduc.WebBE.Entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    private final ProductRepository productRepository;

    @Autowired
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> findByName(String name) {
        return productRepository.findByNameContaining(name);
    }
}
