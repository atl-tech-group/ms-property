package com.msproperty.controller;

import com.msproperty.model.request.SaveRegionRequest;
import com.msproperty.model.request.UpdateRegionRequest;
import com.msproperty.model.response.RegionResponse;
import com.msproperty.service.RegionService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.HttpStatus.*;

@RestController
@RequestMapping("/api/v1/region")
@RequiredArgsConstructor
public class RegionController {
    private final RegionService regionService;

    @GetMapping("/{id}")
    public ResponseEntity<RegionResponse> getRegionById(@PathVariable Long id) {
        return ResponseEntity.status(OK).body(regionService.getRegionById(id));
    }

    @PostMapping
    public ResponseEntity<Void> saveRegion(@Valid @RequestBody SaveRegionRequest request) {
        regionService.saveRegion(request);
        return ResponseEntity.status(CREATED).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> updateRegion(@Valid @PathVariable Long id, @RequestBody UpdateRegionRequest request) {
        regionService.updateRegion(id, request);
        return ResponseEntity.status(NO_CONTENT).build();
    }
}
