package com.msproperty.mapper;

import com.msproperty.dao.entity.AttributeCategoryEntity;
import com.msproperty.model.request.SaveAttributeCategoryRequest;
import com.msproperty.model.request.UpdateAttributeCategoryRequest;
import com.msproperty.model.response.AttributeCategoryResponse;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE,
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface AttributeCategoryMapper {
    AttributeCategoryMapper ATTRIBUTE_CATEGORY_MAPPER = Mappers.getMapper(AttributeCategoryMapper.class);

    AttributeCategoryResponse buildAttributeCategoryResponse(AttributeCategoryEntity entity);

    @Mapping(target = "id", ignore = true)
    AttributeCategoryEntity buildAttributeCategoryEntity(SaveAttributeCategoryRequest request);

    void updateAttributeCategoryEntity(@MappingTarget AttributeCategoryEntity entity, UpdateAttributeCategoryRequest request);
}
