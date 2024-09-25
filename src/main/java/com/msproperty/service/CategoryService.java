package com.msproperty.service;

import com.msproperty.dao.entity.CategoryEntity;
import com.msproperty.model.request.SaveCategoryRequest;
import com.msproperty.model.request.UpdateCategoryRequest;
import com.msproperty.model.response.CategoryResponse;

import java.util.List;

public interface CategoryService {
    CategoryResponse getCategoryById(Long id);

    List<CategoryEntity> getAllCategoriesByIds(List<Long> ids);

    void saveCategory(SaveCategoryRequest request);

    void updateCategory(Long id, UpdateCategoryRequest request);
}
