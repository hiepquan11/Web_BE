package com.huynhduc.WebBE.Dao;

import com.huynhduc.WebBE.Entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

@RepositoryRestResource(path = "order")
public interface OrderRepository extends JpaRepository<Order,Integer> {
}
