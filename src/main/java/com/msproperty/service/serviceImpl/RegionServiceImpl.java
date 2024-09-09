package com.msproperty.service.serviceImpl;

import com.msproperty.dao.entity.AttributeEntity;
import com.msproperty.dao.entity.RegionEntity;
import com.msproperty.dao.repository.RegionRepository;
import com.msproperty.model.request.SaveRegionRequest;
import com.msproperty.model.request.UpdateRegionRequest;
import com.msproperty.model.response.RegionResponse;
import com.msproperty.service.RegionService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import static com.msproperty.mapper.AttributeMapper.ATTRIBUTE_MAPPER;
import static com.msproperty.mapper.RegionMapper.REGION_MAPPER;

@Service
@RequiredArgsConstructor
public class RegionServiceImpl implements RegionService {
    private final RegionRepository regionRepository;

    @Override
    public RegionResponse getRegionById(Long id) {
        var region = fetchRegionEntityIfExist(id);
        return REGION_MAPPER.buildRegionResponse(region);
    }

    @Override
    public void saveRegion(SaveRegionRequest request) {
        var entity = REGION_MAPPER.buildRegionEntity(request);
        regionRepository.save(entity);
    }

    @Override
    public void updateRegion(Long id, UpdateRegionRequest request) {
        var region = fetchRegionEntityIfExist(id);
        REGION_MAPPER.updateRegionEntity(region, request);
        regionRepository.save(region);
    }

    private RegionEntity fetchRegionEntityIfExist(Long id) {
        return regionRepository.findById(id).orElseThrow(
                () -> new RuntimeException("REGION_NOT_FOUND")
        );
    }
}
