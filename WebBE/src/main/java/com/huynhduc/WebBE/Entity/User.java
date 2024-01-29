package com.huynhduc.WebBE.Entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Entity
@Data
@Table(name = "User")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private int ID;
    @Column(name = "Username", nullable = false)
    private String Username;
    @Column(name = "Password", nullable = false)
    private String Password;
    @Column(name = "Fullname", nullable = false)
    private String Fullname;
    @Column(name = "Phonenumber", nullable = false)
    private String Phonenumber;
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
}
