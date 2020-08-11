package com.example.controller.admin.api;

import com.example.dto.NewDTO;
import com.example.service.INewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/admin/new")
public class NewAPI {

    @Autowired
    private INewService newService;

    @PostMapping
    public ResponseEntity<NewDTO> createNew(@RequestBody NewDTO newDTO) {
        return ResponseEntity.ok(newService.insert(newDTO));
    }

    @PutMapping("/{id}")
    public ResponseEntity<NewDTO> updateNew(@RequestBody NewDTO newDTO, @PathVariable("id") long id) {
        return ResponseEntity.ok(newService.update(newDTO, id));
    }

    @DeleteMapping
    public ResponseEntity<Void> deleteNew(@RequestBody long[] id) {
        if (id.length > 0) {
            newService.deleteNew(id);
        }
        return ResponseEntity.noContent().build();
    }
}
