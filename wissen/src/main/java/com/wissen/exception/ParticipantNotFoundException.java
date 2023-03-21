package com.wissen.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ParticipantNotFoundException extends RuntimeException {
//    private String message;
//    public ParticipantNotFoundException(String message){
//        super(message);
//        this.message =message;
//    }
}
