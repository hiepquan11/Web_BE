package com.huynhduc.WebBE.Entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
@Table(name = "Payment")
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "PaymentID")
    private int PaymentID;
    @Column(name = "PaymentName")
    private String PaymentName;
    @Column(name = "Description")
    private String Description;
    @Column(name = "PaymentFee")
    private double PaymentFee;
    @OneToMany(mappedBy = "Payment", fetch = FetchType.LAZY, cascade = {
            CascadeType.DETACH, CascadeType.MERGE,
            CascadeType.PERSIST, CascadeType.REFRESH
    })
    private List<Order> ListOrder;
}
