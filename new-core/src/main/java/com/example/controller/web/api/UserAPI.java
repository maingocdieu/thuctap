package com.example.controller.web.api;

import com.example.dto.NewDTO;
import com.example.dto.UserDTO;
import com.example.service.INewService;
import com.example.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/user")
public class UserAPI {

    @Autowired
    private IUserService userService;

    @PostMapping
    public ResponseEntity<Integer> createUser(@RequestBody UserDTO userDTO) {
        return ResponseEntity.ok(userService.insert(userDTO));
    }
}
