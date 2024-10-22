package com.msproperty.service;

import com.msproperty.dao.entity.PropertyEntity;
import com.msproperty.model.criteria.PageCriteria;
import com.msproperty.model.criteria.UserCriteria;
import com.msproperty.model.request.SavePropertyRequest;
import com.msproperty.model.response.PropertyResponse;
import com.msproperty.model.response.PropertyResponseFein;
import jakarta.persistence.LockModeType;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.Lock;

public interface PropertyService {
    PropertyResponse getPropertyById(Long id);
    Page<PropertyEntity> getAllProducts(PageCriteria pageCriteria, UserCriteria userCriteria);

    @Lock(value = LockModeType.PESSIMISTIC_FORCE_INCREMENT)
    PropertyResponseFein getForFeinPropertyById(Long id);
    void saveProperty(SavePropertyRequest request);
}
