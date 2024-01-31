package com.huynhduc.WebBE.Entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
@Table(name = "Delivery")
public class Delivery {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "DeliveryID")
    private int DeliveryID;
    @Column(name = "DeliveryName")
    private String DeliveryName;
    @Column(name = "Description")
    private String Description;
    @Column(name = "DeliveryFee")
    private double DeliveryFee;
    @OneToMany(mappedBy = "Delivery", fetch = FetchType.LAZY, cascade = {
            CascadeType.PERSIST, CascadeType.MERGE,
            CascadeType.DETACH, CascadeType.REFRESH
    })
    private List<Order> ListOrder;
}
