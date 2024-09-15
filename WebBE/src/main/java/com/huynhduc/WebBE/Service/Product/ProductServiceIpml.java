package com.huynhduc.WebBE.Service.Product;

import com.huynhduc.WebBE.Dao.CategoryRepository;
import com.huynhduc.WebBE.Dao.ImageRepository;
import com.huynhduc.WebBE.Dao.ProductRepository;
import com.huynhduc.WebBE.Entity.Category;
import com.huynhduc.WebBE.Entity.Image;
import com.huynhduc.WebBE.Entity.Notify;
import com.huynhduc.WebBE.Entity.Product;
import com.huynhduc.WebBE.Service.Image.ImageService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceIpml implements ProductService{

    @Autowired
    private CategoryRepository categoryRepository;
    @Autowired
    private ImageRepository imageRepository;
    @Autowired
    private ImageService imageService;
    @Autowired
    private ProductRepository productRepository;

    @Override
    public ResponseEntity<?> saveProduct(Product product) {

        try{
            if(product.getName() == null){
                return ResponseEntity.badRequest().body(new Notify("Product name is required"));
            }
            if(product.getQuantity() <= 0){
                return ResponseEntity.badRequest().body(new Notify("Product quantity is not lower 0"));
            }
            if(product.getPrice() <= 0){
                return ResponseEntity.badRequest().body(new Notify("Product price is not lower 0"));
            }
            if(product.getDescription() == null){
                return ResponseEntity.badRequest().body(new Notify("Product description is required"));
            }

            for(Category arrCategory : product.getListCategory()){
                List<Category> category = categoryRepository.findByCategoryID(arrCategory.getCategoryID());
                product.setListCategory(category);
            }
            Product newProduct = productRepository.save(product);

            for(Image arrImage : newProduct.getListImage()){
                Image image = new Image();
                image.setProduct(newProduct);
                image.setName(newProduct.getName());
                image.setImageURL(arrImage.getImageURL());
                imageRepository.save(image);
            }
        } catch(Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }

        return ResponseEntity.ok(new Notify("Product saved successfully"));
    }

    @Override
    @Transactional
    public ResponseEntity<?> updateProduct(Product product) {
        return null;
    }
}
