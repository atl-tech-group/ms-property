package com.msproperty.model.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

import java.math.BigDecimal;
import java.util.List;

import static lombok.AccessLevel.PRIVATE;

@Data
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = PRIVATE)
public class SavePropertyRequest {
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
