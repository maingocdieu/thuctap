package com.example.service;

import com.example.dto.CategoryDTO;
import com.example.dto.NewDTO;

import java.util.List;

public interface INewService {
    NewDTO insert(NewDTO newDTO);
    NewDTO update(NewDTO updateNew, long id);
    List<NewDTO> findAll(NewDTO model);
    NewDTO findById(long id);
    int getTotalItem();
    void deleteNew(long[] id);
    List<CategoryDTO> getCategories();
    List<NewDTO> getNewsByCategory(String code);
}
