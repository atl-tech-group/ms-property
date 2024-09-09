package com.msproperty.mapper;

import com.msproperty.dao.entity.PropertyTypeEntity;
import com.msproperty.model.request.SavePropertyTypeRequest;
import com.msproperty.model.request.UpdatePropertyTypeRequest;
import com.msproperty.model.response.PropertyTypeResponse;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE,
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface PropertyTypeMapper {
    PropertyTypeMapper PROPERTY_TYPE_MAPPER = Mappers.getMapper(PropertyTypeMapper.class);

    PropertyTypeResponse buildPropertyTypeResponse(PropertyTypeEntity entity);

    @Mapping(target = "id", ignore = true)
    PropertyTypeEntity buildPropertyTypeEntity(SavePropertyTypeRequest request);

    void updatePropertyTypeEntity(@MappingTarget PropertyTypeEntity entity, UpdatePropertyTypeRequest request);
}
