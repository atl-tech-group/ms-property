package com.msproperty.model.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

import static lombok.AccessLevel.PRIVATE;

@Data
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = PRIVATE)
public class SaveAttributeRequest {

    @NotBlank(message = "Attribute name is required")
    String attributeName;

    @NotBlank(message = "Description is required")
    String description;

    @NotNull(message = "Attribute category is required")
    Long attributeCategory;
}
