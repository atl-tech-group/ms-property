package com.msproperty.controller;

import com.msproperty.model.request.SaveCategoryRequest;
import com.msproperty.model.request.SaveCountryRequest;
import com.msproperty.model.request.UpdateCategoryRequest;
import com.msproperty.model.request.UpdateCountryRequest;
import com.msproperty.model.response.CategoryResponse;
import com.msproperty.model.response.CountryResponse;
import com.msproperty.service.CategoryService;
import com.msproperty.service.CountryService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.HttpStatus.*;

@RestController
@RequestMapping("api/v1/country")
@RequiredArgsConstructor
public class CountryController {
    private final CountryService countryService;
    @GetMapping("/{id}")
    public ResponseEntity<CountryResponse> getCountryById(@PathVariable Long id) {
        return ResponseEntity.status(OK).body(countryService.getCountryById(id));
    }

    @PostMapping
    public ResponseEntity<Void> saveCountry(@Valid @RequestBody SaveCountryRequest request) {
        countryService.saveCountry(request);
        return ResponseEntity.status(CREATED).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> updateCountry(@Valid @PathVariable Long id, @RequestBody UpdateCountryRequest request) {
        countryService.updateCountry(id, request);
        return ResponseEntity.status(NO_CONTENT).build();
    }
}
