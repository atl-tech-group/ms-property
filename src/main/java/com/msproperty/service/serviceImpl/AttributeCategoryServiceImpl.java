package com.msproperty.service.serviceImpl;

import com.msproperty.dao.entity.AttributeCategoryEntity;
import com.msproperty.dao.repository.AttributeCategoryRepository;
import com.msproperty.model.request.SaveAttributeCategoryRequest;
import com.msproperty.model.request.UpdateAttributeCategoryRequest;
import com.msproperty.model.response.AttributeCategoryResponse;
import com.msproperty.service.AttributeCategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import static com.msproperty.mapper.AttributeCategoryMapper.ATTRIBUTE_CATEGORY_MAPPER;
import static com.msproperty.model.enums.ErrorMessage.CATEGORY_ATTRIBUTE_NOT_FOUND_BY_ID;

@Service
@RequiredArgsConstructor
public class AttributeCategoryServiceImpl implements AttributeCategoryService {
    private final AttributeCategoryRepository attributeCategoryRepository;

    @Override
    public AttributeCategoryResponse getAttributeCategoryById(Long id) {
        var attributeCategory = fetchAttributeCategoryEntityIfExist(id);
        return ATTRIBUTE_CATEGORY_MAPPER.buildAttributeCategoryResponse(attributeCategory);
    }

    @Override
    public void saveAttributeCategory(SaveAttributeCategoryRequest request) {
        var entity = ATTRIBUTE_CATEGORY_MAPPER.buildAttributeCategoryEntity(request);
        attributeCategoryRepository.save(entity);
    }

    @Override
    public void updateAttributeCategory(Long id, UpdateAttributeCategoryRequest request) {
        var attributeCategory = fetchAttributeCategoryEntityIfExist(id);
        ATTRIBUTE_CATEGORY_MAPPER.updateAttributeCategoryEntity(attributeCategory, request);
        attributeCategoryRepository.save(attributeCategory);
    }

    private AttributeCategoryEntity fetchAttributeCategoryEntityIfExist(Long id) {
        return attributeCategoryRepository.findById(id).orElseThrow(
                () -> new RuntimeException(CATEGORY_ATTRIBUTE_NOT_FOUND_BY_ID.format(id))
        );
    }
}
