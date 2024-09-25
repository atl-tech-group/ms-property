package com.msproperty.service.serviceImpl;

import com.msproperty.dao.entity.CategoryEntity;
import com.msproperty.dao.repository.CategoryRepository;
import com.msproperty.model.request.SaveCategoryRequest;
import com.msproperty.model.request.UpdateCategoryRequest;
import com.msproperty.model.response.CategoryResponse;
import com.msproperty.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.msproperty.mapper.CategoryMapper.CATEGORY_MAPPER;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {
    private final CategoryRepository categoryRepository;

    @Override
    public CategoryResponse getCategoryById(Long id) {
        var attributeCategory = fetchCategoryEntityIfExist(id);
        return CATEGORY_MAPPER.buildCategoryResponse(attributeCategory);
    }

    @Override
    public List<CategoryEntity> getAllCategoriesByIds(List<Long> ids) {
        return categoryRepository.findAllById(ids);
    }

    @Override
    public void saveCategory(SaveCategoryRequest request) {
        var entity = CATEGORY_MAPPER.buildCategoryEntity(request);
        categoryRepository.save(entity);
    }

    @Override
    public void updateCategory(Long id, UpdateCategoryRequest request) {
        var attribute = fetchCategoryEntityIfExist(id);
        CATEGORY_MAPPER.updateCategoryEntity(attribute, request);
        categoryRepository.save(attribute);
    }

    private CategoryEntity fetchCategoryEntityIfExist(Long id) {
        return categoryRepository.findById(id).orElseThrow(
                () -> new RuntimeException("ATTRIBUTE_NOT_FOUND")
        );
    }
}
