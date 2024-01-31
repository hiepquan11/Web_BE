package com.huynhduc.WebBE.Dao;

import com.huynhduc.WebBE.Entity.Image;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(path = "image")
public interface ImageRepository extends JpaRepository<Image, Integer> {
}
