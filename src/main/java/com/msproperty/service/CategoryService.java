package com.msproperty.service;

import com.msproperty.model.request.SaveCategoryRequest;
import com.msproperty.model.request.UpdateCategoryRequest;
import com.msproperty.model.response.CategoryResponse;

public interface CategoryService {
    CategoryResponse getCategoryById (Long id);

    void saveCategory(SaveCategoryRequest request);

    void updateCategory (Long id, UpdateCategoryRequest request);
}
