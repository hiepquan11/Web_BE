package com.huynhduc.WebBE.Entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "Image")
public class Image {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ImageID")
    private int imageID;

    @Column(name = "ImageName")
    private String name;
    
    @Column(name = "ImageURL", nullable = false)
    private String imageURL;

    @Column(name = "ImageData", columnDefinition = "LONGTEXT")
    @Lob
    private String imageData;

    @ManyToOne(cascade = {
            CascadeType.PERSIST, CascadeType.DETACH,
            CascadeType.REFRESH, CascadeType.MERGE
    })
    @JoinColumn(name = "ProductID")
    @JsonIgnore
    private Product product;
}
