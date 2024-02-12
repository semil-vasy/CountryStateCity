package com.example.crud.exception;

import java.io.Serial;

public class ResourceNotFoundException extends RuntimeException {

    /**
     *
     */
    @Serial
    private static final long serialVersionUID = 1L;

    public int status;

    public ResourceNotFoundException(String message) {
        super(message);
    }

    public ResourceNotFoundException(int status, String message) {
        super(message);
        this.status = status;
    }

    public ResourceNotFoundException() {
        super();
    }

}
