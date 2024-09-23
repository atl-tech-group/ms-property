package com.msproperty.mapper;

import com.msproperty.dao.entity.AttributeEntity;
import com.msproperty.model.request.SaveAttributeRequest;
import com.msproperty.model.request.UpdateAttributeRequest;
import com.msproperty.model.response.AttributeResponse;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE,
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface AttributeMapper {
    AttributeMapper ATTRIBUTE_MAPPER = Mappers.getMapper(AttributeMapper.class);

    @Mapping(target = "attributeCategory", source = "attributeCategory.id")
    AttributeResponse buildAttributeResponse(AttributeEntity entity);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "attributeCategory.id", source = "attributeCategory")
    AttributeEntity buildAttributeEntity(SaveAttributeRequest request);

    @Mapping(target = "attributeCategory",
            expression = "java(AttributeCategoryEntity.builder().id(request.getAttributeCategory()).build())")
    void updateAttributeEntity(@MappingTarget AttributeEntity entity, UpdateAttributeRequest request);
}
