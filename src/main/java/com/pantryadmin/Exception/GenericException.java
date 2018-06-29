package com.pantryadmin.Exception;

import org.springframework.http.HttpStatus;

public class GenericException extends RuntimeException{

    private HttpStatus status = HttpStatus.BAD_REQUEST;

    public GenericException() {
    }

    public GenericException(HttpStatus status, String message) {
        super(message);
        this.status = status;
    }

    public GenericException(String message) {
        super(message);
    }

    public HttpStatus getStatus() {
        return status;
    }
}
