package com.msproperty.model.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

import java.time.LocalDateTime;
import java.util.Map;

import static lombok.AccessLevel.PRIVATE;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = PRIVATE)
public class ExceptionResponse {
    String message;
    Integer statusCode;
    String error;
    Map<String, String> errors;
    LocalDateTime timestamp;
}