package com.company.handler;

import com.company.dto.ErrorDTO;
import com.company.exception.EmailAlreadyExistsException;
import com.company.exception.EntityDoesNotExistsException;
import com.company.exception.UserDoesNotHaveThatBookException;
import com.company.exception.UserHaveToManyBooksException;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.ServletWebRequest;
import org.springframework.web.context.request.WebRequest;

import java.util.Date;


@ControllerAdvice
@RestController
public class GlobalExceptionHandler {

    @ExceptionHandler(value = {EmailAlreadyExistsException.class})
    public ResponseEntity<ErrorDTO> handleEmailAlreadyExistsException(
            EmailAlreadyExistsException ex, WebRequest request) {
        ErrorDTO errorDTO = handleException((ServletWebRequest) request,
                ex.getMessage());
        return ResponseEntity.ok(errorDTO);
    }

    @ExceptionHandler(value = {UserHaveToManyBooksException.class})
    public ResponseEntity<ErrorDTO> handleUserHaveToManyBooksExceptionException(
            UserHaveToManyBooksException ex, WebRequest request) {
        ErrorDTO errorDTO = handleException((ServletWebRequest) request, ex.getMessage());
        return ResponseEntity.ok(errorDTO);
    }

    @ExceptionHandler(value = {EntityDoesNotExistsException.class})
    public ResponseEntity<ErrorDTO> handleUserHaveToManyBooksException(
            EntityDoesNotExistsException ex, WebRequest request) {
        ErrorDTO errorDTO = handleException((ServletWebRequest) request, ex.getMessage());
        return ResponseEntity.ok(errorDTO);
    }

    @ExceptionHandler(value = {UserDoesNotHaveThatBookException.class})
    public ResponseEntity<ErrorDTO> handleUserDoesNotHaveThatBookException(
            UserDoesNotHaveThatBookException ex, WebRequest request) {
        ErrorDTO errorDTO = handleException((ServletWebRequest) request, ex.getMessage());
        return ResponseEntity.ok(errorDTO);
    }

    //Handle rest exception
    @ExceptionHandler(value
            = {Exception.class})
    public ResponseEntity<ErrorDTO> handleValidationException(Exception ex, WebRequest request) {
        ErrorDTO errorDTO = handleException((ServletWebRequest) request, ex.getMessage());
        return ResponseEntity.ok(errorDTO);
    }

    //Handle validation
    @ExceptionHandler(value
            = {MethodArgumentNotValidException.class})
    public ResponseEntity<ErrorDTO> handleValidationException(MethodArgumentNotValidException ex, WebRequest request) {
        StringBuilder stringBuilder = new StringBuilder();
        for(ObjectError ob : ex.getAllErrors() ){
            stringBuilder.append(ob.getObjectName()).append(" ").append(ob.getDefaultMessage()).append(" ");
        }

        ErrorDTO errorDTO = handleException((ServletWebRequest) request, stringBuilder.toString());
        return ResponseEntity.ok(errorDTO);
    }

    private ErrorDTO handleException(ServletWebRequest request, String message) {
        return new ErrorDTO(message,
                request.getRequest().getRequestURI()
                , new Date());
    }


}
