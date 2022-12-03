package com.trilectus.user.service.exceptions;

public class ResourseNotFoundExceptions extends RuntimeException {

    public ResourseNotFoundExceptions() {
        super("Resource not found.");
    }

    public ResourseNotFoundExceptions(String message) {
        super(message);
    }
}
