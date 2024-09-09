package com.msproperty.service.serviceImpl;

import com.msproperty.dao.entity.PlaceTypeEntity;
import com.msproperty.dao.repository.PlaceTypeRepository;
import com.msproperty.model.request.SavePlaceTypeRequest;
import com.msproperty.model.request.UpdatePlaceTypeRequest;
import com.msproperty.model.response.PlaceTypeResponse;
import com.msproperty.service.PlaceTypeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import static com.msproperty.mapper.PlaceTypeMapper.PLACE_TYPE_MAPPER;

@Service
@RequiredArgsConstructor
public class PlaceTypeServiceImpl implements PlaceTypeService {
    private final PlaceTypeRepository placeTypeRepository;

    @Override
    public PlaceTypeResponse getPlaceTypeById(Long id) {
        var placeType = fetchPlaceTypeEntityIfExist(id);
        return PLACE_TYPE_MAPPER.buildPlaceTypeResponse(placeType);
    }

    @Override
    public void savePlaceType(SavePlaceTypeRequest request) {
        var entity = PLACE_TYPE_MAPPER.buildPlaceTypeEntity(request);
        placeTypeRepository.save(entity);
    }

    @Override
    public void updatePlaceType(Long id, UpdatePlaceTypeRequest request) {
        var placeType = fetchPlaceTypeEntityIfExist(id);
        PLACE_TYPE_MAPPER.updatePlaceTypeEntity(placeType, request);
        placeTypeRepository.save(placeType);
    }

    private PlaceTypeEntity fetchPlaceTypeEntityIfExist(Long id) {
        return placeTypeRepository.findById(id).orElseThrow(
                () -> new RuntimeException("PLACE_TYPE_NOT_FOUND")
        );
    }
}
