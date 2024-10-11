package com.msproperty.service;

import com.msproperty.dao.entity.PropertyEntity;
import com.msproperty.model.criteria.PageCriteria;
import com.msproperty.model.criteria.UserCriteria;
import com.msproperty.model.request.SavePropertyRequest;
import com.msproperty.model.response.PropertyResponse;
<<<<<<< HEAD
import org.springframework.data.domain.Page;

public interface PropertyService {
    PropertyResponse getPropertyById(Long id);

    Page<PropertyEntity> getAllProducts(PageCriteria pageCriteria, UserCriteria userCriteria);

=======
import com.msproperty.model.response.PropertyResponseFein;

public interface PropertyService {
    PropertyResponse getPropertyById(Long id);
    PropertyResponseFein getForFeinPropertyById(Long id);
>>>>>>> 83a6d4de51cc4b5342834046a5c8bf0274360638
    void saveProperty(SavePropertyRequest request);
}
