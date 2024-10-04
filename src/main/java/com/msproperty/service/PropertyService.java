package com.msproperty.service;

import com.msproperty.model.request.SavePropertyRequest;
import com.msproperty.model.response.PropertyResponse;
import com.msproperty.model.response.PropertyResponseFein;

public interface PropertyService {
    PropertyResponse getPropertyById(Long id);
    PropertyResponseFein getForFeinPropertyById(Long id);
    void saveProperty(SavePropertyRequest request);
}
