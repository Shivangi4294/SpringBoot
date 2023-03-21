package com.wissen.handler;

import com.wissen.exception.IdNotFoundException;
import com.wissen.exception.MandatoryFieldException;
import com.wissen.exception.ParticipantNotFoundException;
import com.wissen.payload.ErrorDetails;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Date;

@RestControllerAdvice
public class ParticipantExceptionHandler{
    @ExceptionHandler(ParticipantNotFoundException.class)
    public ResponseEntity<ErrorDetails> handleParticipantNotFoundException(ParticipantNotFoundException exception, WebRequest webRequest){
        ErrorDetails errorDetails = new ErrorDetails(new Date(),"No participants to show.",webRequest.getDescription(false));
        return  new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND);
    }
    @ExceptionHandler(IdNotFoundException.class)
    public ResponseEntity<ErrorDetails> handleIdNotFoundException(IdNotFoundException exception, WebRequest webRequest){
        ErrorDetails errorDetails = new ErrorDetails(new Date(),"Participant not found.",webRequest.getDescription(false));
        return  new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(MandatoryFieldException.class)
    public ResponseEntity<ErrorDetails> handleMandatoryFieldException(MandatoryFieldException exception, WebRequest webRequest){
        ErrorDetails errorDetails = new ErrorDetails(new Date(),"ParticipantName is mandatory.",webRequest.getDescription(false));
        return  new ResponseEntity<>(errorDetails, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(FileNotFoundException.class)
    public ResponseEntity<ErrorDetails> handleFileNotFoundException(FileNotFoundException exception, WebRequest webRequest){
        ErrorDetails errorDetails = new ErrorDetails(new Date(),"File not found.",webRequest.getDescription(false));
        return  new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(IOException.class)
    public ResponseEntity<ErrorDetails> handleIOException(IOException exception, WebRequest webRequest){
        ErrorDetails errorDetails = new ErrorDetails(new Date(),"IO Exception",webRequest.getDescription(false));
        return  new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND);
    }
}
