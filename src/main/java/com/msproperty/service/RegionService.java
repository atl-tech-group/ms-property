package com.msproperty.service;

import com.msproperty.model.request.SaveRegionRequest;
import com.msproperty.model.request.UpdateRegionRequest;
import com.msproperty.model.response.RegionResponse;

public interface RegionService {
    RegionResponse getRegionById(Long id);

    void saveRegion(SaveRegionRequest request);

    void updateRegion(Long id, UpdateRegionRequest request);
}
