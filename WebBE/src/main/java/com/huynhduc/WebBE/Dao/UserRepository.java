package com.huynhduc.WebBE.Dao;

import com.huynhduc.WebBE.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

@RepositoryRestResource(path = "user")
public interface UserRepository extends JpaRepository<User, Integer> {

    boolean existsByUserName(String username);
    boolean existsByEmail(String email);
    public User findByUserName(String username);
    public User findByEmail(String email);
    User findByID(int id);
}
