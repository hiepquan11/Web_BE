package com.huynhduc.WebBE.Entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "Image")
public class Image {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ImageID")
    private int ImageID;
    @Column(name = "ImageName", nullable = false)
    private String Name;
    @Column(name = "ImageURL", nullable = false)
    private String ImageURL;
    @Column(name = "ImageData", columnDefinition = "LONGTEXT")
    @Lob
    private String ImageData;
    @ManyToOne(cascade = {
            CascadeType.PERSIST, CascadeType.DETACH, CascadeType.ALL, CascadeType.MERGE
    })
    @JoinColumn(name = "ProductID", nullable = false)
    private Product Product;
}
