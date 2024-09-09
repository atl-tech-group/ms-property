package com.msproperty.mapper;

import com.msproperty.dao.entity.RegionEntity;
import com.msproperty.model.request.SaveRegionRequest;
import com.msproperty.model.request.UpdateRegionRequest;
import com.msproperty.model.response.RegionResponse;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE,
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface RegionMapper {
    RegionMapper REGION_MAPPER = Mappers.getMapper(RegionMapper.class);

    RegionResponse buildRegionResponse(RegionEntity entity);

    @Mapping(target = "id", ignore = true)
    RegionEntity buildRegionEntity(SaveRegionRequest request);

    void updateRegionEntity(@MappingTarget RegionEntity entity, UpdateRegionRequest request);
}
