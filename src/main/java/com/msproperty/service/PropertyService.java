package com.msproperty.service;

import com.msproperty.model.request.SavePropertyRequest;
import com.msproperty.model.response.PropertyResponse;

public interface PropertyService {
    PropertyResponse getPropertyById(Long id);

    void saveProperty(SavePropertyRequest request);
}
