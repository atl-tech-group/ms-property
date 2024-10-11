package com.msproperty.controller;

import com.msproperty.dao.entity.PropertyEntity;
import com.msproperty.model.criteria.PageCriteria;
import com.msproperty.model.criteria.UserCriteria;
import com.msproperty.model.request.SavePropertyRequest;
import com.msproperty.model.response.PropertyResponse;
import com.msproperty.model.response.PropertyResponseFein;
import com.msproperty.service.serviceImpl.PropertyServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.HttpStatus.OK;

@RestController
@RequestMapping("/api/v1/property")
@RequiredArgsConstructor
public class PropertyController {
    private final PropertyServiceImpl propertyService;

    @GetMapping("/{id}")
    public PropertyResponse getPropertyById(@PathVariable Long id) {
        return propertyService.getPropertyById(id);
    }

<<<<<<< HEAD
    @PostMapping("/search")
    public ResponseEntity<Page<PropertyEntity>> getAllProducts(PageCriteria pageCriteria, UserCriteria userCriteria) {
        return ResponseEntity.status(OK).body(propertyService.getAllProducts(pageCriteria, userCriteria));
=======
    @GetMapping("/fein/{id}")
    public PropertyResponseFein getForFeinPropertyById(@PathVariable Long id) {
        return propertyService.getForFeinPropertyById(id);
>>>>>>> 83a6d4de51cc4b5342834046a5c8bf0274360638
    }

    @PostMapping
    public void saveProperty(@RequestBody SavePropertyRequest request) {
        propertyService.saveProperty(request);
    }
}
