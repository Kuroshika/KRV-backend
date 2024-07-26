package com.kuka.krv.service.exceptions;


public class SubmissionNotFoundException extends RuntimeException {

    public SubmissionNotFoundException(String message) {
        super(message);
    }

    public SubmissionNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}
