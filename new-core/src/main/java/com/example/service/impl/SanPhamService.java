package com.example.service.impl;

import com.example.converter.CategoryConverter;
import com.example.converter.NewConverter;
import com.example.converter.SanPhamConverter;
import com.example.dto.CategoryDTO;
import com.example.dto.NewDTO;
import com.example.dto.SanPhamDTO;
import com.example.entity.CategoryEntity;
import com.example.entity.SanPhamEntity;
import com.example.repository.CategoryRepository;
import com.example.repository.SanPhamRepository;
import com.example.service.ISanPhamService;
import com.example.util.UploadFileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;
import java.util.stream.Collectors;


@Service
public class SanPhamService implements ISanPhamService {
    @Autowired
    private SanPhamConverter sanPhamConverter;

    @Autowired
    private SanPhamRepository sanPhamRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private UploadFileUtils uploadFileUtils;

    @Autowired
    private CategoryConverter categoryConverter;

    @Override
    @Transactional
    public SanPhamDTO insert(SanPhamDTO sanPhamDTO) {
        SanPhamEntity sanPhamEntity = sanPhamConverter.convertToEntity(sanPhamDTO);
        sanPhamEntity.setCategory(categoryRepository.findOneByCode(sanPhamDTO.getCategoryCode()));
        if (sanPhamDTO.getBase64() != null) {
            String base64Image = sanPhamDTO.getBase64().split(",")[1];
            byte[] decodeBase64 = Base64.getDecoder().decode(base64Image.getBytes());
            uploadFileUtils.writeOrUpdate(decodeBase64, "/thumbnail/"+sanPhamDTO.getFileName());
            sanPhamEntity.setThumbnail("/usr/var/thumbnail/"+sanPhamDTO.getFileName());
        }
        return sanPhamConverter.convertToDto(sanPhamRepository.save(sanPhamEntity));
    }

    @Override
    @Transactional
    public SanPhamDTO update(SanPhamDTO updatesanPhamDTO, long id) {
        SanPhamEntity existSanPham = sanPhamRepository.findOne(id);
        SanPhamEntity updatesanPhamEntity =sanPhamConverter.convertToEntity(updatesanPhamDTO);
        updatesanPhamEntity.setCreatedDate(existSanPham.getCreatedDate());
        updatesanPhamEntity.setCreatedBy(existSanPham.getCreatedBy());
        updatesanPhamEntity.setThumbnail(existSanPham.getThumbnail());
        updatesanPhamEntity.setCategory(categoryRepository.findOneByCode(updatesanPhamDTO.getCategoryCode()));
        if (updatesanPhamDTO.getBase64() != null) {
            String base64Image = updatesanPhamDTO.getBase64().split(",")[1];
            byte[] decodeBase64 = Base64.getDecoder().decode(base64Image.getBytes());
            uploadFileUtils.writeOrUpdate(decodeBase64, "/thumbnail/"+updatesanPhamDTO.getFileName());
            updatesanPhamEntity.setThumbnail("/usr/var/thumbnail/"+updatesanPhamDTO.getFileName());
        }
        updatesanPhamEntity= sanPhamRepository.save(updatesanPhamEntity);
        return sanPhamConverter.convertToDto(updatesanPhamEntity);
    }

    @Override
    public List<SanPhamDTO> findAll(SanPhamDTO model) {
        Page<SanPhamEntity> pages = sanPhamRepository.findAll(new PageRequest(model.getPage() - 1, model.getMaxPageItems()));
        return pages.getContent().stream().map(item -> sanPhamConverter.convertToDto(item)).collect(Collectors.toList());
    }

    @Override
    public List<SanPhamDTO> findAll() {
        return sanPhamRepository.findAll().stream().map(item -> sanPhamConverter.convertToDto(item)).collect(Collectors.toList());
    }


    @Override
    public SanPhamDTO findById(long id) {
        SanPhamEntity sanPhamEntity = sanPhamRepository.findOne(id);
        SanPhamDTO sanPhamDTO = sanPhamConverter.convertToDto(sanPhamEntity);
        sanPhamDTO.setCategoryCode(sanPhamEntity.getCategory().getCode());
        return sanPhamDTO;
    }

    @Override
    public int getTotalItem() {
        return (int) sanPhamRepository.count();
    }

    @Override
    public void deleteNew(long[] id) {
        for (long item: id) {
            sanPhamRepository.delete(item);
        }
    }

    @Override
    public List<CategoryDTO> getCategories() {
        //java 7
        /*List<CategoryEntity> entities = categoryRepository.findAll();
        List<CategoryDTO> dtos = new ArrayList<>();
        for (CategoryEntity item: entities) {
            CategoryDTO categoryDTO = categoryConverter.convertToDto(item);
            dtos.add(categoryDTO);
        }*/
        /*Java 8*/
        return categoryRepository.findAll().stream().map(item -> categoryConverter.convertToDto(item)).collect(Collectors.toList());
    }

    @Override
    public List<SanPhamDTO> getSanPhamByCategory(String categoryCode) {
        CategoryEntity category = categoryRepository.findOneByCode(categoryCode);
        return sanPhamRepository.findByCategory(category).stream().map(item -> sanPhamConverter.convertToDto(item)).collect(Collectors.toList());
    }
}
