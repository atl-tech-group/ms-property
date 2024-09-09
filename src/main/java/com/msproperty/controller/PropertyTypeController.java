package com.msproperty.controller;

import com.msproperty.model.request.SavePlaceTypeRequest;
import com.msproperty.model.request.SavePropertyTypeRequest;
import com.msproperty.model.request.UpdatePlaceTypeRequest;
import com.msproperty.model.request.UpdatePropertyTypeRequest;
import com.msproperty.model.response.PlaceTypeResponse;
import com.msproperty.model.response.PropertyTypeResponse;
import com.msproperty.service.PlaceTypeService;
import com.msproperty.service.PropertyService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.HttpStatus.*;

@RestController
@RequestMapping("api/v1/property-type")
@RequiredArgsConstructor
public class PropertyTypeController {
    private final PropertyService propertyService;
    @GetMapping("/{id}")
    public ResponseEntity<PropertyTypeResponse> getLocationById(@PathVariable Long id) {
        return ResponseEntity.status(OK).body(propertyService.getPropertyTypeById(id));
    }

    @PostMapping
    public ResponseEntity<Void> savePropertyType(@Valid @RequestBody SavePropertyTypeRequest request) {
        propertyService.savePropertyType(request);
        return ResponseEntity.status(CREATED).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> updatePropertyType(@Valid @PathVariable Long id, @RequestBody UpdatePropertyTypeRequest request) {
        propertyService.updatePropertyType(id, request);
        return ResponseEntity.status(NO_CONTENT).build();
    }
}
