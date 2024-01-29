package com.huynhduc.WebBE.Dao;

import com.huynhduc.WebBE.Entity.Galery;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GaleryRepositoory extends JpaRepository<Galery, Integer> {
}
