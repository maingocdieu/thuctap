package com.example.service.impl;

import com.example.converter.CategoryConverter;
import com.example.converter.NewConverter;
import com.example.converter.UserConverter;
import com.example.dto.CategoryDTO;
import com.example.dto.NewDTO;
import com.example.dto.UserDTO;
import com.example.entity.CategoryEntity;
import com.example.entity.NewEntity;
import com.example.entity.RoleEntity;
import com.example.entity.UserEntity;
import com.example.repository.CategoryRepository;
import com.example.repository.NewRepository;
import com.example.repository.RoleRepository;
import com.example.repository.UserRepository;
import com.example.service.INewService;
import com.example.service.IUserService;
import com.example.util.UploadFileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Base64;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService implements IUserService {

    @Autowired
    private UserConverter userConverter;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    @Transactional
    public Integer insert(UserDTO userDTO) {
        List<RoleEntity> roleEntities = new ArrayList<>();
        UserEntity userEntity = userConverter.convertToEntity(userDTO);
        userEntity.setPassword(passwordEncoder.encode(userDTO.getPassword()));

        RoleEntity roleEntity = roleRepository.findOneByCode(userDTO.getCode());

        //RoleEntity roleEntity = roleRepository.findOneByCode("USER");
        roleEntities.add(roleEntity);

        userEntity.setRoles(roleEntities);

        userRepository.save(userEntity);
        return 1;
    }

}
