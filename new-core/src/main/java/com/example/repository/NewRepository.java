package com.example.repository;

import com.example.entity.CategoryEntity;
import com.example.entity.NewEntity;
import com.example.repository.custom.NewRepositoryCustom;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface NewRepository extends JpaRepository<NewEntity, Long>, NewRepositoryCustom {
    Page<NewEntity> findAll(Pageable pageable);
    List<NewEntity> findByCategory(CategoryEntity category);
}
