package com.msproperty.service;

import com.msproperty.model.request.SaveAttributeRequest;
import com.msproperty.model.request.UpdateAttributeRequest;
import com.msproperty.model.response.AttributeResponse;

public interface AttributeService {
    AttributeResponse getAttributeById (Long id);

    void saveAttribute(SaveAttributeRequest request);

    void updateAttribute (Long id, UpdateAttributeRequest request);
}
