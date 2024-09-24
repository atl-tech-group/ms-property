package com.msproperty.mapper;

import com.msproperty.dao.entity.LocationEntity;
import com.msproperty.model.request.SaveLocationRequest;
import com.msproperty.model.request.UpdateLocationRequest;
import com.msproperty.model.response.LocationResponse;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE,
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface LocationMapper {
    LocationMapper LOCATION_MAPPER = Mappers.getMapper(LocationMapper.class);

    @Mapping(target = "country", source = "country.id")
    LocationResponse buildLocationResponse(LocationEntity entity);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "country.id", source = "country")
    LocationEntity buildCountryEntity(SaveLocationRequest request);

    @Mapping(target = "country", expression = "java(CountryEntity.builder().id(request.getCountry()).build())")
    void updateLocationEntity(@MappingTarget LocationEntity entity, UpdateLocationRequest request);

}
