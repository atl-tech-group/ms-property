package com.msproperty.service.serviceImpl;

<<<<<<< HEAD
import com.msproperty.dao.entity.PropertyEntity;
=======
>>>>>>> 83a6d4de51cc4b5342834046a5c8bf0274360638
import com.msproperty.dao.repository.PropertyRepository;
import com.msproperty.model.criteria.PageCriteria;
import com.msproperty.model.criteria.UserCriteria;
import com.msproperty.model.request.SavePropertyRequest;
import com.msproperty.model.response.PropertyResponse;
import com.msproperty.model.response.PropertyResponseFein;
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
<<<<<<< HEAD
    public Page<PropertyEntity> getAllProducts(PageCriteria pageCriteria, UserCriteria userCriteria) {

        var users = propertyRepository.findAll(new UserSpecification(userCriteria),
                PageRequest.of(pageCriteria.getPage(), pageCriteria.getCount()));

        return users;
    }

=======
    public PropertyResponseFein getForFeinPropertyById(Long id) {
        var propertyId = propertyRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Property not found By " + id + "id"));

        return new PropertyResponseFein(
                propertyId.getId()
        );
    }


>>>>>>> 83a6d4de51cc4b5342834046a5c8bf0274360638
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
