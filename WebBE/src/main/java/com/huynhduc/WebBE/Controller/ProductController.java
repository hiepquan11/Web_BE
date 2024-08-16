package com.huynhduc.WebBE.Controller;

import com.huynhduc.WebBE.Entity.Product;
import com.huynhduc.WebBE.Service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/product")
public class ProductController {
    private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {           
        this.productService = productService;
    }


}
