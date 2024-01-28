package com.huynhduc.WebBE.Entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Entity
@Data
@Table(name = "Feedback")
public class Feedback {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private int ID;
    @ManyToOne(cascade = {
            CascadeType.PERSIST, CascadeType.DETACH, CascadeType.ALL, CascadeType.MERGE
    })
    @JoinColumn(name = "UserID")
    private User UserID;
    @ManyToOne(cascade = {
            CascadeType.PERSIST, CascadeType.DETACH, CascadeType.ALL, CascadeType.MERGE
    })
    @JoinColumn(name = "ProductID")
    private Product ProductID;
    @Column(name = "Rating")
    private int Rating;
    @Column(name = "Comment", columnDefinition = "text")
    private String Comment;
    @Column(name = "Created_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date Created_at;
    @Column(name = "Updated_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date Updated_at;
}
