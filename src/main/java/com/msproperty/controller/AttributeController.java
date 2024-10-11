package com.msproperty.controller;

import com.msproperty.model.request.SaveAttributeRequest;
import com.msproperty.model.request.UpdateAttributeRequest;
import com.msproperty.model.response.AttributeResponse;
import com.msproperty.service.AttributeService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.HttpStatus.*;

@RestController
@RequestMapping("/api/v1/attribute")
@RequiredArgsConstructor
public class AttributeController {
    private final AttributeService attributeService;

    @GetMapping("/{id}")
    public ResponseEntity<AttributeResponse> getAttributeById(@PathVariable Long id) {
        return ResponseEntity.status(OK).body(attributeService.getAttributeById(id));
    }

    @PostMapping
    public ResponseEntity<Void> saveAttribute(@Valid @RequestBody SaveAttributeRequest request) {
        attributeService.saveAttribute(request);
        return ResponseEntity.status(CREATED).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> updateAttribute(@Valid @PathVariable Long id, @RequestBody UpdateAttributeRequest request) {
        attributeService.updateAttribute(id, request);
        return ResponseEntity.status(NO_CONTENT).build();
    }
}
