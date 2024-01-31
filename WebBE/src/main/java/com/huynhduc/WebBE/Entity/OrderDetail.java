package com.huynhduc.WebBE.Entity;

import jakarta.persistence.*;
import lombok.Data;
import org.springframework.context.annotation.EnableMBeanExport;

import java.awt.print.Book;
import java.util.List;

@Entity
@Data
@Table(name = "OrderDetail")
public class OrderDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "OrderDetailID")
    private int OrderDetailID;
    @Column(name = "Quantity")
    private int Quantity;
    @Column(name = "Price")
    private double Price;
    @Column(name = "isReview")
    private boolean isReview;
    @ManyToOne(cascade = {CascadeType.REFRESH})
    @JoinColumn(name = "ProductID", nullable = false)
    private Product Product;
    @ManyToOne(cascade = {
            CascadeType.DETACH, CascadeType.MERGE,
            CascadeType.PERSIST, CascadeType.REFRESH
    })
    @JoinColumn(name = "OrderID", nullable = false)
    private Order Order;


}
