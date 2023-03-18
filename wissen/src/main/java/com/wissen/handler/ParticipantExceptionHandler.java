//package com.wissen.handler;
//
//import com.wissen.exception.IdNotFoundException;
//import com.wissen.payload.ErrorDetails;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.HttpStatusCode;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.ExceptionHandler;
//import org.springframework.web.bind.annotation.RestControllerAdvice;
//import org.springframework.web.context.request.WebRequest;
//
//import java.util.Date;
//
//@RestControllerAdvice
//public class ParticipantExceptionHandler {
//
//    @ExceptionHandler(IdNotFoundException.class)
//    public ResponseEntity<ErrorDetails> handleIdNotFoundException(IdNotFoundException exception, WebRequest webRequest){
//        ErrorDetails errorDetails = new ErrorDetails(new Date(),exception.getMessage(),webRequest.getDescription(false));
//        return  new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND);
//    }
//}
