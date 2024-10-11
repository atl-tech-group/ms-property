package com.msproperty.service.serviceImpl;

import com.msproperty.dao.entity.LocationEntity;
import com.msproperty.dao.repository.LocationRepository;
import com.msproperty.model.request.SaveLocationRequest;
import com.msproperty.model.request.UpdateLocationRequest;
import com.msproperty.model.response.LocationResponse;
import com.msproperty.service.LocationService;
import jakarta.ws.rs.NotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import static com.msproperty.mapper.LocationMapper.LOCATION_MAPPER;
import static com.msproperty.model.enums.ErrorMessage.LOCATION_NOT_FOUND_BY_ID;

@Service
@RequiredArgsConstructor
public class LocationServiceImpl implements LocationService {
    private final LocationRepository locationRepository;

    @Override
    public LocationResponse getLocationById(Long id) {
        var location = fetchLocationEntityIfExist(id);
        return LOCATION_MAPPER.buildLocationResponse(location);
    }

    @Override
    public void saveLocation(SaveLocationRequest request) {
        var entity = LOCATION_MAPPER.buildCountryEntity(request);
        locationRepository.save(entity);
    }

    @Override
    public void updateLocation(Long id, UpdateLocationRequest request) {
        var location = fetchLocationEntityIfExist(id);
        LOCATION_MAPPER.updateLocationEntity(location, request);
        locationRepository.save(location);
    }

    private LocationEntity fetchLocationEntityIfExist(Long id) {
        return locationRepository.findById(id).orElseThrow(
                () -> new NotFoundException(LOCATION_NOT_FOUND_BY_ID.format(id))
        );
    }
}
