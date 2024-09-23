package com.msproperty.service.serviceImpl;

import com.msproperty.dao.entity.PropertyTypeEntity;
import com.msproperty.dao.repository.PropertyTypeRepository;
import com.msproperty.model.request.SavePropertyTypeRequest;
import com.msproperty.model.request.UpdatePropertyTypeRequest;
import com.msproperty.model.response.PropertyTypeResponse;
import com.msproperty.service.PropertyTypeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import static com.msproperty.mapper.PropertyTypeMapper.PROPERTY_TYPE_MAPPER;

@Service
@RequiredArgsConstructor
public class PropertyTypeServiceImpl implements PropertyTypeService {

    private final PropertyTypeRepository propertyTypeRepository;

    @Override
    public PropertyTypeResponse getPropertyTypeById(Long id) {
        var propertyType = fetchPropertyTypeEntityIfExist(id);
        return PROPERTY_TYPE_MAPPER.buildPropertyTypeResponse(propertyType);
    }

    @Override
    public void savePropertyType(SavePropertyTypeRequest request) {
        var entity = PROPERTY_TYPE_MAPPER.buildPropertyTypeEntity(request);
        propertyTypeRepository.save(entity);
    }

    @Override
    public void updatePropertyType(Long id, UpdatePropertyTypeRequest request) {
        var propertyType = fetchPropertyTypeEntityIfExist(id);
        PROPERTY_TYPE_MAPPER.updatePropertyTypeEntity(propertyType, request);
        propertyTypeRepository.save(propertyType);
    }

    private PropertyTypeEntity fetchPropertyTypeEntityIfExist(Long id) {
        return propertyTypeRepository.findById(id).orElseThrow(
                () -> new RuntimeException("PROPERTY_TYPE_NOT_FOUND")
        );
    }
}
