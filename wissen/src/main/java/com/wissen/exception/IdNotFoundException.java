package com.wissen.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class IdNotFoundException extends RuntimeException{

    private String message;
    public IdNotFoundException(String message){
         super(message);
         this.message =message;
    }


}
