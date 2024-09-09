package com.msproperty.service;


import com.msproperty.model.request.SavePlaceTypeRequest;
import com.msproperty.model.request.UpdatePlaceTypeRequest;
import com.msproperty.model.response.PlaceTypeResponse;

public interface PlaceTypeService {
    PlaceTypeResponse getPlaceTypeById(Long id);

    void savePlaceType(SavePlaceTypeRequest request);

    void updatePlaceType(Long id, UpdatePlaceTypeRequest request);
}
