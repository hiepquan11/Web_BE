package com.huynhduc.WebBE.Entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Generated;

import java.util.Date;
import java.util.List;
import java.util.Map;

@Entity
@Data
@Table(name = "Product")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ProductID")
    private int ProductID;
    @Column(name = "Name", length = 100, nullable = false)
    private String Name;
    @Column(name = "Quantity", nullable = false)
    private int Quantity;
    @Column(name = "Price", nullable = false)
    private double Price;
    @Column(name = "Discount", nullable = false)
    private double Discount;
    @Column(name = "Description", columnDefinition = "text")
    private String Description;
    @Column(name = "Created_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date Created_at;
    @Column(name = "Updated_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date Updated_at;
    @ManyToMany(fetch = FetchType.LAZY, cascade = {
            CascadeType.REFRESH, CascadeType.PERSIST,
            CascadeType.MERGE, CascadeType.DETACH
    })
    @JoinTable(name = "Product_Category", joinColumns = @JoinColumn(name = "ProductID"), inverseJoinColumns = @JoinColumn(name = "CategoryID"))
    private List<Category> ListCategory;

    @OneToMany(mappedBy = "Product", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Image> ListImage;
    @OneToMany(mappedBy = "Product", fetch = FetchType.LAZY, cascade = {
            CascadeType.PERSIST,CascadeType.DETACH,
            CascadeType.MERGE, CascadeType.REFRESH
    })
    private List<OrderDetail> ListOrderDetail;
    @OneToMany(mappedBy = "Product", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<FavouriteProduct> ListFavouriteProduct;
    @OneToMany(mappedBy = "Product", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Cart> ListCart;
}
