package com.huynhduc.WebBE.Entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
@Table(name = "UserRole")
public class UserRole {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private int ID;
    @ManyToOne(cascade = {
            CascadeType.PERSIST, CascadeType.DETACH, CascadeType.ALL, CascadeType.MERGE
    })
    @JoinColumn(name = "RoleID", nullable = false)
    private Role RoleID;
    @ManyToOne(cascade = {
            CascadeType.PERSIST, CascadeType.DETACH, CascadeType.ALL, CascadeType.MERGE
    })
    @JoinColumn(name = "UserID", nullable = false)
    private User UserID;

}
