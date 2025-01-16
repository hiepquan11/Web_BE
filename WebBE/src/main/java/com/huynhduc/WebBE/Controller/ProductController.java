package com.huynhduc.WebBE.Controller;


import com.huynhduc.WebBE.DTO.Response.ProductResponse;
import com.huynhduc.WebBE.Dao.ProductRepository;
import com.huynhduc.WebBE.Entity.Category;
import com.huynhduc.WebBE.Entity.Image;
import com.huynhduc.WebBE.Entity.Notify;
import com.huynhduc.WebBE.Entity.Product;
import com.huynhduc.WebBE.Service.Image.ImageServiceIpml;
import com.huynhduc.WebBE.Service.Product.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/api")
public class ProductController {

    @Autowired
    private ProductService productService;
    @Autowired
    private ImageServiceIpml imageServiceIpml;
    @Autowired
    private ProductRepository productRepository;

    @GetMapping("/product")
    public ResponseEntity<Object> getAllProduct(){
        return productService.getInfoProduct();
    }

    @GetMapping("/product/{id}")
    public ResponseEntity<ProductResponse> getProductById(@PathVariable int id){
        return ResponseEntity.ok(productService.getProductById(id));
    }

    @PostMapping("/addProduct")
    public ResponseEntity<?> addProduct(@Validated @RequestBody Product product){
        ResponseEntity<?> response = productService.saveProduct(product);
        if(response == null){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Fail to save");
        }
        return response;
    }

    @PutMapping("/updateProduct")
    public ResponseEntity<?> updateProduct(@Validated @RequestParam("productID") int productID, @RequestBody Product product) {
        Optional<Product> productOptional = productRepository.findById(productID);
        if(!productOptional.isPresent()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Product not found");
        }

        Product existingProduct = productOptional.get();
        existingProduct.setName(product.getName());
        existingProduct.setQuantity(product.getQuantity());
        existingProduct.setPrice(product.getPrice());
        existingProduct.setDescription(product.getDescription());
        existingProduct.setListImage(product.getListImage());
        existingProduct.setListCategory(product.getListCategory());
        ResponseEntity<?> response = productService.updateProduct(existingProduct);
       if(response == null){
           return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Fail to update");
       }
       return response;
    }
}
