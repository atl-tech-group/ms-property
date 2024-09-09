package com.msproperty.mapper;

import com.msproperty.dao.entity.CountryEntity;
import com.msproperty.model.request.SaveCountryRequest;
import com.msproperty.model.request.UpdateCountryRequest;
import com.msproperty.model.response.CountryResponse;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE,
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface CountryMapper {
    CountryMapper COUNTRY_MAPPER = Mappers.getMapper(CountryMapper.class);

    @Mapping(target = "region", source = "region.id")
    CountryResponse buildCountryResponse(CountryEntity entity);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "region.id", source = "region")
    CountryEntity buildCountryEntity(SaveCountryRequest request);

    /**
     * @Mapping is not working
     */
    @Mapping(target = "region.id", source = "region")
    void updateCountryEntity(@MappingTarget CountryEntity entity, UpdateCountryRequest request);
}
