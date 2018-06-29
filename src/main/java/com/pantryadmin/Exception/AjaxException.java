package com.pantryadmin.Exception;

import org.springframework.http.HttpStatus;

public class AjaxException extends GenericException {

    private HttpStatus status = HttpStatus.BAD_REQUEST;

    public AjaxException() {
    }

    public AjaxException(HttpStatus status, String message) {
        super(message);
        this.status = status;
    }

    public AjaxException(String message) {
        super(message);
    }

    public HttpStatus getStatus() {
        return status;
    }

}