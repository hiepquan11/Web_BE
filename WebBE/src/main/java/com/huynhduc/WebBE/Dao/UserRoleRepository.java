package com.huynhduc.WebBE.Dao;

import com.huynhduc.WebBE.Entity.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

@RepositoryRestResource(path = "userrole")
public interface UserRoleRepository extends JpaRepository<UserRole, Integer> {
}
