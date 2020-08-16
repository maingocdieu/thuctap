package com.example.service;

import com.example.dto.CategoryDTO;
import com.example.entity.CategoryEntity;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public interface ICategoryService {
    Map<String, String> getCategories();
    List<CategoryEntity> findAll();
}
