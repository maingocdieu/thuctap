package com.example.service.impl;

import com.example.converter.CategoryConverter;
import com.example.converter.NewConverter;
import com.example.dto.CategoryDTO;
import com.example.dto.NewDTO;
import com.example.entity.CategoryEntity;
import com.example.entity.NewEntity;
import com.example.repository.CategoryRepository;
import com.example.repository.NewRepository;
import com.example.security.util.SecurityUtils;
import com.example.service.INewService;
import com.example.util.UploadFileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class NewService implements INewService {

    @Autowired
    private NewConverter newConverter;

    @Autowired
    private NewRepository newRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private UploadFileUtils uploadFileUtils;

    @Autowired
    private CategoryConverter categoryConverter;

    @Override
    @Transactional
    public NewDTO insert(NewDTO newDTO) {
        NewEntity newEntity = newConverter.convertToEntity(newDTO);
        newEntity.setCategory(categoryRepository.findOneByCode(newDTO.getCategoryCode()));
        if (newDTO.getBase64() != null) {
            byte[] decodeBase64 = Base64.getDecoder().decode(newDTO.getBase64().getBytes());
            uploadFileUtils.writeOrUpdate(decodeBase64, "/thumbnail/"+newDTO.getFileName());
            newEntity.setThumbnail("/usr/var/thumbnail/"+newDTO.getFileName());
        }
        return newConverter.convertToDto(newRepository.save(newEntity));
    }

    @Override
    @Transactional
    public NewDTO update(NewDTO updateNewDTO, long id) {
        NewEntity existNew = newRepository.findOne(id);
        NewEntity updateNewEntity = newConverter.convertToEntity(updateNewDTO);
        updateNewEntity.setCreatedDate(existNew.getCreatedDate());
        updateNewEntity.setCreatedBy(existNew.getCreatedBy());
        updateNewEntity.setThumbnail(existNew.getThumbnail());
        updateNewEntity.setCategory(categoryRepository.findOneByCode(updateNewDTO.getCategoryCode()));
        if (updateNewDTO.getBase64() != null) {
            byte[] decodeBase64 = Base64.getDecoder().decode(updateNewDTO.getBase64().getBytes());
            uploadFileUtils.writeOrUpdate(decodeBase64, "/thumbnail/"+updateNewDTO.getFileName());
            updateNewEntity.setThumbnail("/usr/var/thumbnail/"+updateNewDTO.getFileName());
        }
        updateNewEntity = newRepository.save(updateNewEntity);
        return newConverter.convertToDto(updateNewEntity);
    }

    @Override
    public List<NewDTO> findAll(NewDTO model) {
        Page<NewEntity> pages = newRepository.findAll(new PageRequest(model.getPage() - 1, model.getMaxPageItems()));
        return pages.getContent().stream().map(item -> newConverter.convertToDto(item)).collect(Collectors.toList());
    }

    @Override
    public NewDTO findById(long id) {
        NewEntity newEntity = newRepository.findOne(id);
        NewDTO newDTO = newConverter.convertToDto(newEntity);
        newDTO.setCategoryCode(newEntity.getCategory().getCode());
        return newDTO;
    }

    @Override
    public int getTotalItem() {
        return (int) newRepository.count();
    }

    @Override
    public void deleteNew(long[] id) {
        for (long item: id) {
            newRepository.delete(item);
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
    public List<NewDTO> getNewsByCategory(String categoryCode) {
        CategoryEntity category = categoryRepository.findOneByCode(categoryCode);
        return newRepository.findByCategory(category).stream().map(item -> newConverter.convertToDto(item)).collect(Collectors.toList());
    }
}
