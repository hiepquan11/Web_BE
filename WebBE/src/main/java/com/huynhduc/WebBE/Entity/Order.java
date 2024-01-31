package com.huynhduc.WebBE.Entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Collection;
import java.util.Date;
import java.util.List;

@Entity
@Data
@Table(name = "Order")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "OrderID")
    private int OrderID;
    @Column(name = "Created_date")
    private Date Created_date;
    @Column(name = "PhoneNumber")
    private String PhoneNumber;
    @Column(name = "FullName")
    private String FullName;
    @Column(name = "TotalPriceProduct")
    private double TotalPriceProduct;
    @Column(name = "DeliveryFee")
    private double DeliveryFee;
    @Column(name = "PaymentFee")
    private double PaymentFee;
    @Column(name = "TotalPrice")
    private double TotalPrice;
    @Column(name = "Status")
    private String Status;
    @Column(name = "Note")
    private String Note;
    @OneToMany(mappedBy = "Order", cascade = CascadeType.ALL)
    private List<OrderDetail> ListOrderDetail;
    @ManyToOne(cascade = {
            CascadeType.DETACH, CascadeType.MERGE,
            CascadeType.PERSIST, CascadeType.REFRESH
    })
    @JoinColumn(name = "UserID", nullable = false)
    private User User;
    @ManyToOne(cascade = {
            CascadeType.DETACH, CascadeType.MERGE,
            CascadeType.PERSIST, CascadeType.REFRESH
    })
    @JoinColumn(name = "DeliveryID")
    private Delivery Delivery;
    @ManyToOne(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinColumn(name = "PaymentID")
    private Payment Payment;
}
