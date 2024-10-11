package com.msproperty.controller;

import com.msproperty.model.request.SaveCategoryRequest;
import com.msproperty.model.request.UpdateCategoryRequest;
import com.msproperty.model.response.CategoryResponse;
import com.msproperty.service.CategoryService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.HttpStatus.*;

@RestController
@RequestMapping("/api/v1/category")
@RequiredArgsConstructor
public class CategoryController {
    private final CategoryService categoryService;
    @GetMapping("/{id}")
    public ResponseEntity<CategoryResponse> getAttributeById(@PathVariable Long id) {
        return ResponseEntity.status(OK).body(categoryService.getCategoryById(id));
    }

    @PostMapping
    public ResponseEntity<Void> saveAttribute(@Valid @RequestBody SaveCategoryRequest request) {
        categoryService.saveCategory(request);
        return ResponseEntity.status(CREATED).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> updateAttribute(@Valid @PathVariable Long id, @RequestBody UpdateCategoryRequest request) {
        categoryService.updateCategory(id, request);
        return ResponseEntity.status(NO_CONTENT).build();
    }
}
