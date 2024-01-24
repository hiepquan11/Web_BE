package com.huynhduc.WebBE.Entity;

import java.util.Date;
import java.util.List;

public class Product {
    private int ID;
    private Category categoryID;
    private String Tilte;
    private int Quantity;
    private double Price;
    private double Discount;
    private List<Galery> Thumnail;
    private String Description;
    private Date Created_at;
    private Date Updated_at;
    private int Deleted;
}
