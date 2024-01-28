package com.huynhduc.WebBE.Entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
@Table(name = "OrderDetail")
public class OrderDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private int ID;
    @ManyToOne(cascade = {
            CascadeType.PERSIST, CascadeType.DETACH, CascadeType.ALL, CascadeType.MERGE
    })
    @JoinColumn(name = "OrderID", nullable = false)
    private Order OrderID;
    @ManyToOne(cascade = {
            CascadeType.PERSIST, CascadeType.DETACH, CascadeType.ALL, CascadeType.MERGE
    })
    @JoinColumn(name = "ProductID", nullable = false)
    private Product ProductID;
    @Column(name = "Price", nullable = false)
    private double price;
    @Column(name = "Quantity", nullable = false)
    private int Quantity;
}
