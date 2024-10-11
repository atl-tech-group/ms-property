package com.msproperty.model.Enum;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ErrorMessage {
    CATEGORY_ATTRIBUTE_NOT_FOUND_BY_ID("User not found with id: %d"),

    ATTRIBUTE_NOT_FOUND_BY_ID("Attribute not found with id: %d"),

    CATEGORY_NOT_FOUND_BY_ID("Category not found with id: %d"),

    COUNTRY_NOT_FOUND_BY_ID("Country not found with id: %d"),

    LOCATION_NOT_FOUND_BY_ID("Location not found with id: %d"),

    PLACE_TYPE_NOT_FOUND_BY_ID("Place type not found with id: %d"),

    PROPERTY_NOT_FOUND_BY_ID("Property not found with id: %d"),

    PROPERTY_TYPE_NOT_FOUND_BY_ID("Property type not found with id: %d"),

    REGION_NOT_FOUND_BY_ID("Region not found with id: %d");

    private final String message;
    public String format(Object... args) {
        return String.format(message, args);
    }
}
