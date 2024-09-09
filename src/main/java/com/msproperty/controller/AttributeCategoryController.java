package com.msproperty.controller;

import com.msproperty.model.request.SaveAttributeCategoryRequest;
import com.msproperty.model.request.UpdateAttributeCategoryRequest;
import com.msproperty.model.response.AttributeCategoryResponse;
import com.msproperty.service.AttributeCategoryService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.HttpStatus.*;

@RestController
@RequestMapping("api/v1/attribute-category")
@RequiredArgsConstructor
public class AttributeCategoryController {
    private final AttributeCategoryService attributeCategoryService;

    @GetMapping("/{id}")
    public ResponseEntity<AttributeCategoryResponse> getAttributeCategoryById(@PathVariable Long id) {
        return ResponseEntity.status(OK).body(attributeCategoryService.getAttributeCategoryById(id));
    }

    @PostMapping
    public ResponseEntity<Void> saveAttributeCategory(@Valid @RequestBody SaveAttributeCategoryRequest request) {
        attributeCategoryService.saveAttributeCategory(request);
        return ResponseEntity.status(CREATED).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> updateAttributeCategory(@Valid @PathVariable Long id,
                                                        @RequestBody UpdateAttributeCategoryRequest request) {
        attributeCategoryService.updateAttributeCategory(id, request);
        return ResponseEntity.status(NO_CONTENT).build();
    }
}
