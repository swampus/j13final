package com.company.handler;

import com.company.dto.ErrorDTO;
import com.company.exception.EmailAlreadyExistsException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Date;


@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(value
            = {EmailAlreadyExistsException.class})
    public ResponseEntity<ErrorDTO> handleEmailAlreadyExistsException(
            EmailAlreadyExistsException ex, WebRequest request) {
        ErrorDTO errorDTO = new ErrorDTO(ex.getMessage(), request.getContextPath(), new Date());
        return ResponseEntity.ok(errorDTO);
    }

    @ExceptionHandler(value
            = {Exception.class})
    public ResponseEntity<ErrorDTO> handleValidationException(
            Exception ex,
            WebRequest request) {

        ErrorDTO errorDTO = new ErrorDTO(ex.getMessage(), request.getContextPath(), new Date());
        return ResponseEntity.ok(errorDTO);
    }


}
