package com.wissen.exception;

public class MandatoryFieldException extends Exception {
    private String message;
    public MandatoryFieldException(String message){
        super(message);
        this.message =message;
    }
}
