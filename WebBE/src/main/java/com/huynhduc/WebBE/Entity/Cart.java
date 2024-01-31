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
    @ManyToOne
    @JoinColumn(name = "ProductID")
    private Product Product;
    @ManyToOne
    @JoinColumn(name = "UserID", nullable = false)
    private User User;
}
