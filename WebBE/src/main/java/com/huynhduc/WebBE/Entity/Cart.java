package com.huynhduc.WebBE.Entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "Cart")
public class Cart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private int ID;
    @Column(name = "Quantity", nullable = false)
    private int Quantity;
    @ManyToOne(cascade = {
            CascadeType.PERSIST, CascadeType.DETACH, CascadeType.ALL, CascadeType.MERGE
    })
    @JoinColumn(name = "ProductID")
    private Product ProductID;
    @Column(name = "Price")
    private double Price;
    @Column(name = "TotalMoney")
    private double TotalMoney;
}
