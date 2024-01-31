package com.huynhduc.WebBE.Entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Entity
@Data
@Table(name = "User")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "UserID")
    private int ID;
    @Column(name = "UserName", nullable = false)
    private String UserName;
    @Column(name = "Password", nullable = false)
    private String Password;
    @Column(name = "ActivationCode")
    private String ActivationCode;
    @Column(name = "FullName", nullable = false)
    private String Fullname;
    @Column(name = "PhoneNumber", nullable = false)
    private String PhoneNumber;
    @Column(name = "Address", nullable = false)
    private String Address;
    @Column(name = "Created_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date Created_at;
    @Column(name = "Updated_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date Updated_at;
    @Column(name = "Enabled")
    private int Enabled;
    @OneToMany(mappedBy = "User", fetch = FetchType.LAZY, cascade = {
            CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH
    })
    private List<Review> ListReview;
    @OneToMany(mappedBy = "User", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<FavouriteProduct> ListFavouriteProduct;
    @ManyToMany(fetch = FetchType.EAGER,cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinTable(name = "User_Role", joinColumns = @JoinColumn(name = "UserID"), inverseJoinColumns = @JoinColumn(name = "RoleID"))
    private List<Role> ListRole;
    @OneToMany(mappedBy = "User",fetch = FetchType.LAZY, cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    private List<Order> ListOrder;
    @OneToMany(mappedBy = "User",fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Cart> listCartItems;

    @OneToMany(mappedBy = "User",fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Feedback> listFeedbacks;
}
