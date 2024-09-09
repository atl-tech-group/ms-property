package com.msproperty.service;

import com.msproperty.model.request.SaveAttributeCategoryRequest;
import com.msproperty.model.request.UpdateAttributeCategoryRequest;
import com.msproperty.model.response.AttributeCategoryResponse;

public interface AttributeCategoryService {
    AttributeCategoryResponse getAttributeCategoryById (Long id);

    void saveAttributeCategory(SaveAttributeCategoryRequest request);

    void updateAttributeCategory (Long id, UpdateAttributeCategoryRequest request);
}
