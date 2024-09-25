package com.msproperty.service;

import com.msproperty.model.request.SavePropertyTypeRequest;
import com.msproperty.model.request.UpdatePropertyTypeRequest;
import com.msproperty.model.response.PropertyTypeResponse;

public interface PropertyTypeService {

    PropertyTypeResponse getPropertyTypeById(Long id);

    void savePropertyType(SavePropertyTypeRequest request);

    void updatePropertyType(Long id, UpdatePropertyTypeRequest request);
}
