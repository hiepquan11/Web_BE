package com.huynhduc.WebBE.DTO.Response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CartResponse {
    private String productName;
    private int productQuantity;
    private List<String> imageUrl;
    private double price;
    private double totalPrice;
    private int productId;
}
