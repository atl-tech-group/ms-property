package com.msproperty.model.criteria;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserCriteria {
    private String propertyName;
    private BigDecimal lessThanPrice;
    private BigDecimal greaterThanPrice;
    private Integer numGuests;
    private Integer numBeds;
    private Integer numBedrooms;
    private Integer numBathrooms;
    private Integer isGuestFavourite;
    private String addressLine1;
    private String addressLine2;
    private String locationName;
    private String countryName;
}