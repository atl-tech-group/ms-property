package com.msproperty.service;

import com.msproperty.dao.entity.PropertyEntity;
import com.msproperty.model.criteria.PageCriteria;
import com.msproperty.model.criteria.UserCriteria;
import com.msproperty.model.request.SavePropertyRequest;
import com.msproperty.model.response.PropertyResponse;
import org.springframework.data.domain.Page;

public interface PropertyService {
    PropertyResponse getPropertyById(Long id);

    Page<PropertyEntity> getAllProducts(PageCriteria pageCriteria, UserCriteria userCriteria);

    void saveProperty(SavePropertyRequest request);
}
