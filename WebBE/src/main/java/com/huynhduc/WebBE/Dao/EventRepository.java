package com.huynhduc.WebBE.Dao;

import com.huynhduc.WebBE.Entity.Event;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(path = "event")
public interface EventRepository extends JpaRepository<Event, Integer> {
}
