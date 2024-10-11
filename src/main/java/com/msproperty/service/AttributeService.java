package com.msproperty.service;

import com.msproperty.dao.entity.AttributeEntity;
import com.msproperty.model.request.SaveAttributeRequest;
import com.msproperty.model.request.UpdateAttributeRequest;
import com.msproperty.model.response.AttributeResponse;

import java.util.List;

public interface AttributeService {
    AttributeResponse getAttributeById(Long id);

    List<AttributeEntity> getAllAttributesByIds(List<Long> ids);

    void saveAttribute(SaveAttributeRequest request);

    void updateAttribute(Long id, UpdateAttributeRequest request);
}
