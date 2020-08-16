package com.example.controller.admin.api;

import com.example.dto.NewDTO;
import com.example.dto.SanPhamDTO;
import com.example.service.INewService;
import com.example.service.ISanPhamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/admin/sanpham")
public class SanPhamAPI {

    @Autowired
    private ISanPhamService sanPhamService;

    @PostMapping
    public ResponseEntity<SanPhamDTO> createNew(@RequestBody SanPhamDTO sanPhamDTO) {
        System.out.println("Dieu dep trai :"+sanPhamDTO.getBase64());
        return ResponseEntity.ok(sanPhamService.insert(sanPhamDTO));
    }

    @PutMapping("/{id}")
    public ResponseEntity<SanPhamDTO> updateNew(@RequestBody SanPhamDTO sanPhamDTO, @PathVariable("id") long id) {
        return ResponseEntity.ok(sanPhamService.update(sanPhamDTO, id));
    }

    @DeleteMapping
    public ResponseEntity<Void> deleteNew(@RequestBody long[] id) {
        if (id.length > 0) {
            sanPhamService.deleteNew(id);
        }
        return ResponseEntity.noContent().build();
    }
}
