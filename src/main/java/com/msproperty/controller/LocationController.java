package com.msproperty.controller;

import com.msproperty.model.request.SaveCategoryRequest;
import com.msproperty.model.request.SaveLocationRequest;
import com.msproperty.model.request.UpdateCategoryRequest;
import com.msproperty.model.request.UpdateLocationRequest;
import com.msproperty.model.response.CategoryResponse;
import com.msproperty.model.response.LocationResponse;
import com.msproperty.service.CategoryService;
import com.msproperty.service.LocationService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.HttpStatus.*;

@RestController
@RequestMapping("api/v1/location")
@RequiredArgsConstructor
public class LocationController {
    private final LocationService locationService;
    @GetMapping("/{id}")
    public ResponseEntity<LocationResponse> getLocationById(@PathVariable Long id) {
        return ResponseEntity.status(OK).body(locationService.getLocationById(id));
    }

    @PostMapping
    public ResponseEntity<Void> saveLocation(@Valid @RequestBody SaveLocationRequest request) {
        locationService.saveLocation(request);
        return ResponseEntity.status(CREATED).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> updateLocation(@Valid @PathVariable Long id, @RequestBody UpdateLocationRequest request) {
        locationService.updateLocation(id, request);
        return ResponseEntity.status(NO_CONTENT).build();
    }
}
