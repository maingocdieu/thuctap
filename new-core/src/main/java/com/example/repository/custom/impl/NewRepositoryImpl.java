package com.example.repository.custom.impl;

import com.example.repository.custom.NewRepositoryCustom;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
public class NewRepositoryImpl implements NewRepositoryCustom {

    @PersistenceContext
    private EntityManager entityManager;

}
