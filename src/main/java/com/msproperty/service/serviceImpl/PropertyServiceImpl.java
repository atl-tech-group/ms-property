package com.msproperty.service.serviceImpl;

import com.msproperty.dao.repository.PropertyRepository;
import com.msproperty.model.response.PropertyResponse;
import com.msproperty.service.PropertyService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PropertyServiceImpl implements PropertyService {
    private final PropertyRepository propertyRepository;

    @Override
    public PropertyResponse getPropertyById(Long id) {
        var property = propertyRepository.findById(id)
                .orElseThrow(()-> new EntityNotFoundException("Property not found By " + id + "id"));
        return new PropertyResponse(
                property.getId()
        );
    }
}
