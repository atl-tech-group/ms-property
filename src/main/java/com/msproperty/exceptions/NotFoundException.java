package com.msproperty.exceptions;

public class NotFoundException extends RuntimeException {
    NotFoundException(String message) {
        super(message);
    }
}
