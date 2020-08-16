package com.example.repository;

import com.example.entity.CategoryEntity;
import com.example.entity.NewEntity;
import com.example.entity.SanPhamEntity;
import com.example.entity.UserEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SanPhamRepository extends JpaRepository<SanPhamEntity, Long> {
    Page<SanPhamEntity> findAll(Pageable pageable);
    List<SanPhamEntity> findByCategory(CategoryEntity category);
}
