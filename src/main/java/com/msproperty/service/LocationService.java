package com.msproperty.service;

import com.msproperty.model.request.SaveLocationRequest;
import com.msproperty.model.request.UpdateLocationRequest;
import com.msproperty.model.response.LocationResponse;

public interface LocationService {
    LocationResponse getLocationById(Long id);

    void saveLocation(SaveLocationRequest request);

    void updateLocation(Long id, UpdateLocationRequest request);
}
