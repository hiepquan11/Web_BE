package com.huynhduc.WebBE.DTO.Response;

import com.huynhduc.WebBE.Entity.Category;
import com.huynhduc.WebBE.Entity.Image;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductResponse {
    private int productId;
    private String productName;
    private String productDescription;
    private double productPrice;
    private List<Category> categories;
    private List<Image> productImages;
}
