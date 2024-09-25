package com.msproperty.service.serviceImpl;

import com.msproperty.dao.entity.AttributeEntity;
import com.msproperty.dao.repository.AttributeRepository;
import com.msproperty.model.request.SaveAttributeRequest;
import com.msproperty.model.request.UpdateAttributeRequest;
import com.msproperty.model.response.AttributeResponse;
import com.msproperty.service.AttributeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.msproperty.mapper.AttributeMapper.ATTRIBUTE_MAPPER;

@Service
@RequiredArgsConstructor
public class AttributeServiceImpl implements AttributeService {
    private final AttributeRepository attributeRepository;

    @Override
    public AttributeResponse getAttributeById(Long id) {
        var attributeCategory = fetchAttributeEntityIfExist(id);
        return ATTRIBUTE_MAPPER.buildAttributeResponse(attributeCategory);
    }

    @Override
    public List<AttributeEntity> getAllAttributesByIds(List<Long> ids) {
        return attributeRepository.findAllById(ids);
    }

    @Override
    public void saveAttribute(SaveAttributeRequest request) {
        var entity = ATTRIBUTE_MAPPER.buildAttributeEntity(request);
        attributeRepository.save(entity);
    }

    @Override
    public void updateAttribute(Long id, UpdateAttributeRequest request) {
        var attribute = fetchAttributeEntityIfExist(id);
        ATTRIBUTE_MAPPER.updateAttributeEntity(attribute, request);
        attributeRepository.save(attribute);
    }

    private AttributeEntity fetchAttributeEntityIfExist(Long id) {
        return attributeRepository.findById(id).orElseThrow(
                () -> new RuntimeException("ATTRIBUTE_NOT_FOUND")
        );
    }
}
