package com.msproperty.service.specification;


import com.msproperty.dao.entity.CountryEntity;
import com.msproperty.dao.entity.LocationEntity;
import com.msproperty.dao.entity.PlaceTypeEntity;
import com.msproperty.dao.entity.PropertyEntity;
import com.msproperty.model.criteria.UserCriteria;
import com.msproperty.utility.PredicateUtil;
import jakarta.persistence.criteria.*;
import lombok.AllArgsConstructor;
import org.springframework.data.jpa.domain.Specification;

import static com.msproperty.utility.PredicateUtil.applyLikePattern;


@AllArgsConstructor
public class UserSpecification implements Specification<PropertyEntity> {
    private UserCriteria cr;

    @Override
    public Predicate toPredicate(Root<PropertyEntity> root, CriteriaQuery<?> query, CriteriaBuilder cb) {

        Join<PropertyEntity, LocationEntity> locationJoin = root.join("location", JoinType.LEFT);
        Join<LocationEntity, CountryEntity> countryJoin = locationJoin.join("country", JoinType.INNER);


        var predicates = PredicateUtil.builder()
                .addNullSafety(cr.getLessThanPrice(),
                        nightlyPrice -> cb.lessThanOrEqualTo(root.get("nightly_price"), cr.getLessThanPrice()))
                .addNullSafety(cr.getLessThanPrice(),
                        nightlyPrice -> cb.greaterThanOrEqualTo(root.get("nightly_price"), cr.getGreaterThanPrice()))
                .addNullSafety(cr.getPropertyName(),
                        propertyName -> cb.like(cb.lower(root.get("property_name")), applyLikePattern(propertyName)))
                .addNullSafety(cr.getNumGuests(),
                        numGuests -> cb.equal(root.get("num_guests"), numGuests))
                .addNullSafety(cr.getNumBeds(),
                        numBeds -> cb.equal(root.get("num_beds"), numBeds))
                .addNullSafety(cr.getNumBedrooms(),
                        numBedrooms -> cb.equal(root.get("num_bedrooms"), numBedrooms))
                .addNullSafety(cr.getNumBathrooms(),
                        numBathrooms -> cb.equal(root.get("num_bathrooms"), numBathrooms))
                .addNullSafety(cr.getIsGuestFavourite(),
                        isGuestFavourite -> cb.equal(root.get("is_guest_favourite"), isGuestFavourite))
                .addNullSafety(cr.getAddressLine1(),
                        addressLine_1 -> cb.like(cb.lower(root.get("address_line_1")), applyLikePattern(addressLine_1)))
                .addNullSafety(cr.getAddressLine2(),
                        addressLine_2 -> cb.like(cb.lower(root.get("address_line_2")), applyLikePattern(addressLine_2)))
                .addNullSafety(cr.getLocationName(),
                        locationName -> cb.like(cb.lower(locationJoin.get("locationName")), applyLikePattern(locationName)))
                .addNullSafety(cr.getCountryName(),
                        countryName -> cb.like(cb.lower(countryJoin.get("countryName")), applyLikePattern(countryName)))
                .build();

        return cb.and(predicates);
    }
}
