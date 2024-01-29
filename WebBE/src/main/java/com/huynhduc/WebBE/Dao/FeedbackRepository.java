package com.huynhduc.WebBE.Dao;

import com.huynhduc.WebBE.Entity.Feedback;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

@RepositoryRestResource(path = "feedback")
public interface FeedbackRepository extends JpaRepository<Feedback, Integer> {
}
