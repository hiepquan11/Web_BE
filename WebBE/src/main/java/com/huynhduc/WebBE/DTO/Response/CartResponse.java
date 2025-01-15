package com.huynhduc.WebBE.DTO.Response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CartResponse {
    private String productName;
    private int productQuantity;
    private double price;
    private double totalPrice;
}
