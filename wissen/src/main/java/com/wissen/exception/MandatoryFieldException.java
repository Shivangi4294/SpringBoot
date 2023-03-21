package com.wissen.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class MandatoryFieldException extends RuntimeException {
//    private String message;
//    public MandatoryFieldException(String message){
//        super(message);
//        this.message =message;
//    }
}
