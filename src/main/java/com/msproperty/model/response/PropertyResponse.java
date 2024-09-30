package com.msproperty.model.response;

import com.msproperty.dao.entity.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import java.math.BigDecimal;
import java.util.List;

import static lombok.AccessLevel.PRIVATE;

@Setter
@Getter
@AllArgsConstructor
@FieldDefaults(level = PRIVATE)
public class PropertyResponse {
    Long id;
    BigDecimal nightly_price;
    String property_name;
    Integer num_guests;
    Integer num_beds;
    Integer num_bedrooms;
    Integer num_bathrooms;
    Integer is_guest_favourite;
    String description;
    String address_line_1;
    String address_line_2;

    Long location;
    Long placeType;
    Long propertyType;
    List<Long> attributes;
    List<Long> categories;
}
