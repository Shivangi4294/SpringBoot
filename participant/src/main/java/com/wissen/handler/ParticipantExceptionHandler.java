package com.wissen.handler;

import com.wissen.exception.IdNotFoundException;
import com.wissen.exception.MandatoryFieldException;
import com.wissen.exception.ParticipantNotFoundException;
import com.wissen.model.ErrorDetails;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import java.io.FileNotFoundException;
import java.io.IOException;

@RestControllerAdvice
public class ParticipantExceptionHandler {
    @ExceptionHandler(ParticipantNotFoundException.class)
    public ResponseEntity<ErrorDetails> handleParticipantNotFoundException(ParticipantNotFoundException exception, WebRequest webRequest) {
        ErrorDetails errorDetails = new ErrorDetails( exception.getMessage(), webRequest.getDescription(false));
        return new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(IdNotFoundException.class)
    public ResponseEntity<ErrorDetails> handleIdNotFoundException(IdNotFoundException exception, WebRequest webRequest) {
        ErrorDetails errorDetails = new ErrorDetails(exception.getMessage(), webRequest.getDescription(false));
        return new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(MandatoryFieldException.class)
    public ResponseEntity<ErrorDetails> handleMandatoryFieldException(MandatoryFieldException exception, WebRequest webRequest) {
        ErrorDetails errorDetails = new ErrorDetails(exception.getMessage(), webRequest.getDescription(false));
        return new ResponseEntity<>(errorDetails, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(FileNotFoundException.class)
    public ResponseEntity<ErrorDetails> handleFileNotFoundException(FileNotFoundException exception, WebRequest webRequest) {
        ErrorDetails errorDetails = new ErrorDetails(exception.getMessage(), webRequest.getDescription(false));
        return new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(IOException.class)
    public ResponseEntity<ErrorDetails> handleIOException(IOException exception, WebRequest webRequest) {
        ErrorDetails errorDetails = new ErrorDetails(exception.getMessage(), webRequest.getDescription(false));
        return new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorDetails> handleException(Exception exception, WebRequest webRequest) {
        ErrorDetails errorDetails = new ErrorDetails(exception.getMessage(), webRequest.getDescription(false));
        return new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND);
    }
}
