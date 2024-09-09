package com.msproperty.mapper;

import com.msproperty.dao.entity.CountryEntity;
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

    /**
     * @Mapping is not working
     */
//    @Mapping(target = "country.id", source = "country")
    @Mapping(target = "country", expression = "java(demo(request.getCountry()))")
    void updateLocationEntity(@MappingTarget LocationEntity entity, UpdateLocationRequest request);

    default CountryEntity demo(Long country) {
        return CountryEntity.builder().id(country).build();
    }
}
