package com.huynhduc.WebBE.Service.Product;

import com.huynhduc.WebBE.Entity.Product;
import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

public interface ProductService {
    public ResponseEntity<?> saveProduct(Product product);
    public ResponseEntity<?> updateProduct(Product product);
}
