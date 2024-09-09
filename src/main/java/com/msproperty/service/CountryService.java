package com.msproperty.service;


import com.msproperty.model.request.SaveCountryRequest;
import com.msproperty.model.request.UpdateCountryRequest;
import com.msproperty.model.response.CountryResponse;

public interface CountryService {
    CountryResponse getCountryById(Long id);

    void saveCountry(SaveCountryRequest request);

    void updateCountry(Long id, UpdateCountryRequest request);
}
