package com.huynhduc.WebBE.Dao;

import com.huynhduc.WebBE.Entity.Galery;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

@RepositoryRestResource(path = "galery")
public interface GaleryRepositoory extends JpaRepository<Galery, Integer> {
}
