package com.example.service;

import com.example.dto.CategoryDTO;
import com.example.dto.NewDTO;
import com.example.dto.SanPhamDTO;
import com.example.repository.Paging.Pageable;

import java.util.List;

public interface ISanPhamService {

    SanPhamDTO insert(SanPhamDTO sanPhamDTO);
    SanPhamDTO update(SanPhamDTO updateNew, long id);
    List<SanPhamDTO> findAll(SanPhamDTO model);
    List<SanPhamDTO> findAll();
    SanPhamDTO findById(long id);
    int getTotalItem();
    void deleteNew(long[] id);
    List<CategoryDTO> getCategories();
    List<SanPhamDTO> getSanPhamByCategory(String code);
}
