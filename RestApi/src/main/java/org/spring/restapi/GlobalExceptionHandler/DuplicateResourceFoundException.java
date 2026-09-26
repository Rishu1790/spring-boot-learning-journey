package org.spring.restapi.GlobalExceptionHandler;

public class DuplicateResourceFoundException extends RuntimeException {
    public DuplicateResourceFoundException(String message ){
        super(message);
    }
}
