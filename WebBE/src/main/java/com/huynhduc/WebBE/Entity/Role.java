package com.huynhduc.WebBE.Entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
@Table(name = "Role")
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "RoleID")
    private int RoleID;
    @Column(name = "RoleName", nullable = false)
    private String RoleName;
    @ManyToMany(fetch = FetchType.LAZY, cascade = {
            CascadeType.DETACH, CascadeType.MERGE,
            CascadeType.PERSIST, CascadeType.REFRESH
    })
    @JoinTable(name = "User_Role", joinColumns = @JoinColumn(name = "RoleID"), inverseJoinColumns = @JoinColumn(name = "UserID"))
    List<User> ListUser;
}
