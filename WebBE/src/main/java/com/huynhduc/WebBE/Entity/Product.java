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
    @Column(name = "ID")
    private int ID;
    @ManyToOne(cascade = {
            CascadeType.PERSIST, CascadeType.DETACH, CascadeType.ALL, CascadeType.MERGE
    })
    @JoinColumn(name = "CategoryID", nullable = false)
    private Category CategoryID;
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
    @Column(name = "Deleted")
    private int Deleted;
}
