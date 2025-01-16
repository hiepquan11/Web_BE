package com.huynhduc.WebBE.Service.Product;

import com.huynhduc.WebBE.DTO.Response.ProductResponse;
import com.huynhduc.WebBE.Entity.Product;
import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface ProductService {
    ResponseEntity<?> saveProduct(Product product);
    ResponseEntity<?> updateProduct(Product product);
    ResponseEntity<Object> getInfoProduct();
    ProductResponse getProductById(int productId);
}
