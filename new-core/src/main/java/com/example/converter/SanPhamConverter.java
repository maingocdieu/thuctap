package com.example.converter;

import com.example.dto.SanPhamDTO;
import com.example.dto.UserDTO;
import com.example.entity.SanPhamEntity;
import com.example.entity.UserEntity;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SanPhamConverter {

    @Autowired
    private ModelMapper modelMapper;

    public SanPhamDTO convertToDto(SanPhamEntity entity) {
        SanPhamDTO result = modelMapper.map(entity, SanPhamDTO.class);
        return result;
    }

    public SanPhamEntity convertToEntity(SanPhamDTO sanPhamDTO) {
        SanPhamEntity result = modelMapper.map(sanPhamDTO, SanPhamEntity.class);
        return result;
    }
}
