package com.huynhduc.WebBE.Entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;
@Entity
@Data
@Table(name = "Category")
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CategoryID")
    private int categoryID;
    @Column(name = "CategoryName",nullable = false)
    private String categoryName;
    @ManyToMany(fetch = FetchType.LAZY, cascade = {
            CascadeType.DETACH, CascadeType.MERGE,
            CascadeType.PERSIST, CascadeType.REFRESH
    })

    @JoinTable(name = "Product_Category", joinColumns = @JoinColumn(name = "CategoryID"), inverseJoinColumns = @JoinColumn(name = "ProductID"))
    private List<Product> listProduct;


}
