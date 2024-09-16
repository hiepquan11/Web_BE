package com.huynhduc.WebBE.Controller;


import com.huynhduc.WebBE.Entity.Product;
import com.huynhduc.WebBE.Service.Image.ImageServiceIpml;
import com.huynhduc.WebBE.Service.Product.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;


@RestController
@RequestMapping("/api/product")
public class ProductController {

    @Autowired
    private ProductService productService;
    @Autowired
    private ImageServiceIpml imageServiceIpml;

    @PostMapping("/addProduct")
    public ResponseEntity<?> addProduct(@Validated @RequestBody Product product){
        ResponseEntity<?> response = productService.saveProduct(product);
        if(response == null){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Fail to save");
        }
        return response;
    }
}
