package com.huynhduc.WebBE.DTO.Response;

public class ItemRemove {
    private int productId;

    public ItemRemove() {
    }

    public ItemRemove(int productId) {
        this.productId = productId;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }
}
