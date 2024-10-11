package com.msproperty.model.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import static lombok.AccessLevel.PRIVATE;

@Setter
@Getter
@FieldDefaults(level = PRIVATE)
@AllArgsConstructor
public class PropertyResponseFein {
    Long id;
}
