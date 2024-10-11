package com.msproperty.controller;

import com.msproperty.model.request.SavePlaceTypeRequest;
import com.msproperty.model.request.UpdatePlaceTypeRequest;
import com.msproperty.model.response.PlaceTypeResponse;
import com.msproperty.service.PlaceTypeService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.HttpStatus.*;

@RestController
@RequestMapping("/api/v1/place-type")
@RequiredArgsConstructor
public class PlaceTypeController {
    private final PlaceTypeService placeTypeService;
    @GetMapping("/{id}")
    public ResponseEntity<PlaceTypeResponse> getLocationById(@PathVariable Long id) {
        return ResponseEntity.status(OK).body(placeTypeService.getPlaceTypeById(id));
    }

    @PostMapping
    public ResponseEntity<Void> savePlaceType(@Valid @RequestBody SavePlaceTypeRequest request) {
        placeTypeService.savePlaceType(request);
        return ResponseEntity.status(CREATED).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> updatePlaceType(@Valid @PathVariable Long id, @RequestBody UpdatePlaceTypeRequest request) {
        placeTypeService.updatePlaceType(id, request);
        return ResponseEntity.status(NO_CONTENT).build();
    }
}
