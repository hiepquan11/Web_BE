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
    private int FeedBackID;
    @Column(name = "Title")
    private String Title;
    @Column(name = "Comment", columnDefinition = "LONGTEXT")
    private String Comment;
    @Column(name = "Created_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date Created_date;
    @Column(name = "isRead")
    private boolean isRead;
    @ManyToOne(cascade = {
            CascadeType.DETACH, CascadeType.MERGE,
            CascadeType.PERSIST, CascadeType.REFRESH
    })
    @JoinColumn(name = "UserID",nullable = false)
    private User User;

}
