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
    private int ImageID;

    @Column(name = "ImageName")
    private String Name;
    
    @Column(name = "ImageURL", nullable = false)
    private String imageURL;

    @Column(name = "ImageData", columnDefinition = "LONGTEXT")
    @Lob
    private String ImageData;

    @ManyToOne(cascade = {
            CascadeType.PERSIST, CascadeType.DETACH,
            CascadeType.REFRESH, CascadeType.MERGE
    })
    @JoinColumn(name = "ProductID")
    @JsonIgnore
    private Product Product;
}
