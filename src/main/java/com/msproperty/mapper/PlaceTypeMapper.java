package com.msproperty.mapper;

import com.msproperty.dao.entity.PlaceTypeEntity;
import com.msproperty.model.request.SavePlaceTypeRequest;
import com.msproperty.model.request.UpdatePlaceTypeRequest;
import com.msproperty.model.response.PlaceTypeResponse;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE,
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface PlaceTypeMapper {
    PlaceTypeMapper PLACE_TYPE_MAPPER = Mappers.getMapper(PlaceTypeMapper.class);

    PlaceTypeResponse buildPlaceTypeResponse(PlaceTypeEntity entity);

    @Mapping(target = "id", ignore = true)
    PlaceTypeEntity buildPlaceTypeEntity(SavePlaceTypeRequest request);

    void updatePlaceTypeEntity(@MappingTarget PlaceTypeEntity entity, UpdatePlaceTypeRequest request);
}
