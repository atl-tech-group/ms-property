package com.msproperty.mapper;

import com.msproperty.dao.entity.CategoryEntity;
import com.msproperty.model.request.SaveCategoryRequest;
import com.msproperty.model.request.UpdateCategoryRequest;
import com.msproperty.model.response.CategoryResponse;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE,
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface CategoryMapper {

    CategoryMapper CATEGORY_MAPPER = Mappers.getMapper(CategoryMapper.class);

    CategoryResponse buildCategoryResponse(CategoryEntity entity);

    @Mapping(target = "id", ignore = true)
    CategoryEntity buildCategoryEntity(SaveCategoryRequest request);

    void updateCategoryEntity(@MappingTarget CategoryEntity entity, UpdateCategoryRequest request);
}
