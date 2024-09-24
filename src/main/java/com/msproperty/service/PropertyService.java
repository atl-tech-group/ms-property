package com.msproperty.service;

import com.msproperty.model.response.PropertyResponse;

public interface PropertyService {
    PropertyResponse getPropertyById(Long id);
}
