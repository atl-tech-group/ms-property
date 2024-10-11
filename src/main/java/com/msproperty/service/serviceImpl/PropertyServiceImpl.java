package com.msproperty.service.serviceImpl;

import com.msproperty.dao.entity.PropertyEntity;
import com.msproperty.dao.repository.PropertyRepository;
import com.msproperty.model.criteria.PageCriteria;
import com.msproperty.model.criteria.UserCriteria;
import com.msproperty.model.request.SavePropertyRequest;
import com.msproperty.model.response.PropertyResponse;
import com.msproperty.service.AttributeService;
import com.msproperty.service.CategoryService;
import com.msproperty.service.PropertyService;
import com.msproperty.service.specification.UserSpecification;
import jakarta.ws.rs.NotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import static com.msproperty.mapper.PropertyMapper.PROPERTY_MAPPER;
import static com.msproperty.model.enums.ErrorMessage.PROPERTY_NOT_FOUND_BY_ID;

@Service
@RequiredArgsConstructor
public class PropertyServiceImpl implements PropertyService {
    private final PropertyRepository propertyRepository;
    private final AttributeService attributeService;
    private final CategoryService categoryService;

    @Override
    public PropertyResponse getPropertyById(Long id) {
        var property = fetchPropertyEntityIfExist(id);

        var propertyResponse = PROPERTY_MAPPER.buildPropertyResponse(property);
        propertyResponse.setAttributes(property.getAttributes().stream().map(p -> p.getId()).toList());
        propertyResponse.setCategories(property.getCategories().stream().map(c -> c.getId()).toList());

        return propertyResponse;
    }

    @Override
    public Page<PropertyEntity> getAllProducts(PageCriteria pageCriteria, UserCriteria userCriteria) {

        var users = propertyRepository.findAll(new UserSpecification(userCriteria),
                PageRequest.of(pageCriteria.getPage(), pageCriteria.getCount()));

        return users;
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

    private PropertyEntity fetchPropertyEntityIfExist(Long id) {
        return propertyRepository.findById(id).orElseThrow(
                () -> new NotFoundException(PROPERTY_NOT_FOUND_BY_ID.format(id))
        );
    }
}
