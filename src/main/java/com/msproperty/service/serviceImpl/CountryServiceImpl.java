package com.msproperty.service.serviceImpl;

import com.msproperty.dao.entity.CountryEntity;
import com.msproperty.dao.repository.CountryRepository;
import com.msproperty.model.request.SaveCountryRequest;
import com.msproperty.model.request.UpdateCountryRequest;
import com.msproperty.model.response.CountryResponse;
import com.msproperty.service.CountryService;
import jakarta.ws.rs.NotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import static com.msproperty.mapper.CountryMapper.COUNTRY_MAPPER;
import static com.msproperty.model.enums.ErrorMessage.COUNTRY_NOT_FOUND_BY_ID;

@Service
@RequiredArgsConstructor
public class CountryServiceImpl implements CountryService {
    private final CountryRepository countryRepository;

    @Override
    public CountryResponse getCountryById(Long id) {
        var country = fetchCountryEntityIfExist(id);
        return COUNTRY_MAPPER.buildCountryResponse(country);
    }

    @Override
    public void saveCountry(SaveCountryRequest request) {
        var entity = COUNTRY_MAPPER.buildCountryEntity(request);
        countryRepository.save(entity);
    }

    @Override
    public void updateCountry(Long id, UpdateCountryRequest request) {
        var country = fetchCountryEntityIfExist(id);
        COUNTRY_MAPPER.updateCountryEntity(country, request);
        countryRepository.save(country);
    }

    private CountryEntity fetchCountryEntityIfExist(Long id) {
        return countryRepository.findById(id).orElseThrow(
                () -> new NotFoundException(COUNTRY_NOT_FOUND_BY_ID.format(id))
        );
    }
}
