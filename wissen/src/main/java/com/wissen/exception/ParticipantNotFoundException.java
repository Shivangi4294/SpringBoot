package com.wissen.exception;

public class ParticipantNotFoundException extends RuntimeException {
    private String message;
    public ParticipantNotFoundException(String message){
        super(message);
        this.message =message;
    }
}
