package com.binaypaul.restfulwebservices.restcontroller;

import com.binaypaul.restfulwebservices.mapstruct.dto.ExceptionResponse;
import com.binaypaul.restfulwebservices.restcontroller.exception.ResourceNotFoundException;
import com.binaypaul.restfulwebservices.restcontroller.exception.UserResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Date;

@ControllerAdvice
@RestController
public class CustomizedResponseEntityExceptionHandlerResource extends ResponseEntityExceptionHandler {

    @ExceptionHandler(Exception.class)
    public final ResponseEntity<Object> handleAllException(
            Exception ex, WebRequest request
    ) throws Exception {
        ExceptionResponse exceptionResponse = ExceptionResponse.builder()
                .exceptionDate(new Date())
                .message(ex.getMessage())
                .details(request.getDescription(true))
                .path(request.getContextPath())
                .build();
        return new ResponseEntity(exceptionResponse, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(ResourceNotFoundException.class)
    public final ResponseEntity<Object> handleAllResourceNotFoundException(
            Exception ex, WebRequest request
    ) throws Exception {
        ExceptionResponse exceptionResponse = ExceptionResponse.builder()
                .exceptionDate(new Date())
                .message(ex.getMessage())
                .details(request.getDescription(true))
                .path(request.getContextPath())
                .build();
        return new ResponseEntity(exceptionResponse, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(UserResourceNotFoundException.class)
    public final ResponseEntity<Object> handleAllUserResourceNotFoundException(
            Exception ex, WebRequest request
    ) throws Exception {
        ExceptionResponse exceptionResponse = ExceptionResponse.builder()
                .exceptionDate(new Date())
                .message(ex.getMessage())
                .details(request.getDescription(true))
                .path(request.getContextPath())
                .build();
        return new ResponseEntity(exceptionResponse, HttpStatus.NOT_FOUND);
    }
}
