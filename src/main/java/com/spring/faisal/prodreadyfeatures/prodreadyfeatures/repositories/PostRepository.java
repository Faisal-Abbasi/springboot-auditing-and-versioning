package com.spring.faisal.prodreadyfeatures.prodreadyfeatures.repositories;

import com.spring.faisal.prodreadyfeatures.prodreadyfeatures.entities.PostEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends JpaRepository<PostEntity,Long> {
}
