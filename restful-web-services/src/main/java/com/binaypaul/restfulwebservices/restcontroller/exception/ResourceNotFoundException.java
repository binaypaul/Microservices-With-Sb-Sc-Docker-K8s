package com.binaypaul.restfulwebservices.restcontroller.exception;

public class ResourceNotFoundException extends RuntimeException {
    public ResourceNotFoundException(String resourceClassName) {
        super(resourceClassName + "_NOT_FOUND");
    }
}
