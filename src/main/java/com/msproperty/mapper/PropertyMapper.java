package com.msproperty.mapper;

import com.msproperty.dao.entity.PropertyEntity;
import com.msproperty.model.request.SavePropertyRequest;
import com.msproperty.model.response.PropertyResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE,
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface PropertyMapper {
    PropertyMapper PROPERTY_MAPPER = Mappers.getMapper(PropertyMapper.class);

    @Mapping(target = "location", source = "location.id")
    @Mapping(target = "placeType", source = "placeType.id")
    @Mapping(target = "propertyType", source = "propertyType.id")
    @Mapping(target = "attributes", ignore = true)
    @Mapping(target = "categories", ignore = true)
    PropertyResponse buildPropertyResponse(PropertyEntity entity);

    @Mapping(target = "location.id", source = "location")
    @Mapping(target = "placeType.id", source = "placeType")
    @Mapping(target = "propertyType.id", source = "propertyType")
    @Mapping(target = "attributes", ignore = true)
    @Mapping(target = "categories", ignore = true)
    PropertyEntity buildPropertyEntity(SavePropertyRequest request);
}
