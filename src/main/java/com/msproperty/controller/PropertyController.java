package com.msproperty.controller;

import com.msproperty.model.request.SavePropertyRequest;
import com.msproperty.model.response.PropertyResponse;
import com.msproperty.model.response.PropertyResponseFein;
import com.msproperty.service.serviceImpl.PropertyServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/property")
@RequiredArgsConstructor
public class PropertyController {
    private final PropertyServiceImpl propertyService;

    @GetMapping("/{id}")
    public PropertyResponse getPropertyById(@PathVariable Long id) {
        return propertyService.getPropertyById(id);
    }

    @GetMapping("/fein/{id}")
    public PropertyResponseFein getForFeinPropertyById(@PathVariable Long id) {
        return propertyService.getForFeinPropertyById(id);
    }

    @PostMapping
    public void saveProperty(@RequestBody SavePropertyRequest request) {
        propertyService.saveProperty(request);
    }
}
