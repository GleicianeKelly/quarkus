package org.acme.exception;

public class InternalServerError extends RuntimeException{

    public InternalServerError(String message) {
        super(message);
    }
}
