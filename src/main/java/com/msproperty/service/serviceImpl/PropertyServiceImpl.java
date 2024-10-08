package com.msproperty.service.serviceImpl;

import com.msproperty.dao.repository.PropertyRepository;
import com.msproperty.model.request.SavePropertyRequest;
import com.msproperty.model.response.PropertyResponse;
import com.msproperty.model.response.PropertyResponseFein;
import com.msproperty.service.AttributeService;
import com.msproperty.service.CategoryService;
import com.msproperty.service.PropertyService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import static com.msproperty.mapper.PropertyMapper.PROPERTY_MAPPER;

@Service
@RequiredArgsConstructor
public class PropertyServiceImpl implements PropertyService {
    private final PropertyRepository propertyRepository;
    private final AttributeService attributeService;
    private final CategoryService categoryService;

    @Override
    public PropertyResponse getPropertyById(Long id) {
        var property = propertyRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Property not found By " + id + "id"));

        var propertyResponse = PROPERTY_MAPPER.buildPropertyResponse(property);
        propertyResponse.setAttributes(property.getAttributes().stream().map(p -> p.getId()).toList());
        propertyResponse.setCategories(property.getCategories().stream().map(c -> c.getId()).toList());

        return propertyResponse;
    }

    @Override
    public PropertyResponseFein getForFeinPropertyById(Long id) {
        var propertyId = propertyRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Property not found By " + id + "id"));

        return new PropertyResponseFein(
                propertyId.getId()
        );
    }


    @Override
    @Transactional
    public void saveProperty(SavePropertyRequest request) {

        var property = PROPERTY_MAPPER.buildPropertyEntity(request);
        var attributes = attributeService.getAllAttributesByIds(request.getAttributes());
        var categories = categoryService.getAllCategoriesByIds(request.getCategories());

        property.setAttributes(attributes);
        property.setCategories(categories);

        propertyRepository.save(property);
    }
}
