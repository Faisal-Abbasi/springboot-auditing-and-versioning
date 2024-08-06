package com.spring.faisal.prodreadyfeatures.prodreadyfeatures.controllers;

import com.spring.faisal.prodreadyfeatures.prodreadyfeatures.entities.PostEntity;
import jakarta.persistence.EntityManagerFactory;
import lombok.RequiredArgsConstructor;
import org.hibernate.envers.AuditReader;
import org.hibernate.envers.AuditReaderFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(path="/audit")
@RequiredArgsConstructor
public class AuditController {

    private final EntityManagerFactory entityManagerFactory;

    @GetMapping(path = "/posts/{postId}")
    public List<PostEntity> getPostRevision(@PathVariable Long postId){
        AuditReader reader= AuditReaderFactory.get(entityManagerFactory.createEntityManager());
        List<Number> revisions= reader.getRevisions(PostEntity.class,postId);
        return revisions.stream().map(revisionsNumber->reader.find(PostEntity.class,postId,revisionsNumber)).collect(Collectors.toList());
    }
}
