package com.huynhduc.WebBE.Entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;

import java.util.Date;
import java.util.List;
import java.util.Map;

@Entity
@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "Product")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ProductID")
    private int productID;
    @Column(name = "Name", length = 100, nullable = false)
    private String name;
    @Column(name = "Quantity", nullable = false)
    private int quantity;
    @Column(name = "Price", nullable = false)
    private double price;
    @Column(name = "Discount")
    private double discount;
    @Column(name = "Description", columnDefinition = "text")
    private String description;
    @Column(name = "Created_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date created_at;
    @Column(name = "Updated_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date updated_at;

    @ManyToMany(fetch = FetchType.LAZY, cascade = {
            CascadeType.REFRESH, CascadeType.PERSIST,
            CascadeType.MERGE, CascadeType.DETACH
    })
    @JsonIgnoreProperties("listProduct")
    @JoinTable(name = "Product_Category", joinColumns = @JoinColumn(name = "ProductID"), inverseJoinColumns = @JoinColumn(name = "CategoryID"))
    private List<Category> listCategory;

    @OneToMany(mappedBy = "product", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Image> listImage;

    @OneToMany(mappedBy = "Product", fetch = FetchType.LAZY, cascade = {
            CascadeType.PERSIST,CascadeType.DETACH,
            CascadeType.MERGE, CascadeType.REFRESH
    })
    private List<OrderDetail> ListOrderDetail;
    @OneToMany(mappedBy = "Product", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<FavouriteProduct> listFavouriteProduct;

    @OneToMany(mappedBy = "product", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Cart> listCart;
}
