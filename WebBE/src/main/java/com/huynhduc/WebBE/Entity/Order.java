package com.huynhduc.WebBE.Entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Entity
@Data
@Table(name = "Order")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private int ID;
    @ManyToOne(cascade = {
            CascadeType.PERSIST, CascadeType.DETACH, CascadeType.ALL, CascadeType.MERGE
    })
    @JoinColumn(name = "UserID", nullable = false)
    private User UserID;
    @Column(name = "Address", nullable = false)
    private String Address;
    @Column(name = "TotalMoney", nullable = false)
    private double TotalMoney;
}
