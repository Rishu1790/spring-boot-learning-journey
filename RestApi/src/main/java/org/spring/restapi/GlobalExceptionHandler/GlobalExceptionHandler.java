package org.spring.restapi.GlobalExceptionHandler;

import jakarta.servlet.http.HttpServletRequest;
import jdk.jshell.Snippet;
import org.spring.restapi.dto.ExceptionResponseDto;
import org.spring.restapi.dto.ValidationExceptionResponseDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class GlobalExceptionHandler {

    // ResourceNot FoundExceprtion

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ExceptionResponseDto> handleResourceNotFoundException(RuntimeException ex, HttpServletRequest req){

        ExceptionResponseDto exceptionResponseDto = new ExceptionResponseDto(
                LocalDateTime.now(),
                HttpStatus.NOT_FOUND.value(),
                HttpStatus.NOT_FOUND.getReasonPhrase(),
                ex.getMessage(),
                req.getRequestURI()
        );



        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(exceptionResponseDto);

    }

    // Duplicate Resource

    @ExceptionHandler(DuplicateResourceFoundException.class)
    public ResponseEntity<ExceptionResponseDto> handleDuplicateResourceFoundException(RuntimeException ex, HttpServletRequest req){

        ExceptionResponseDto exceptionResponseDto = new ExceptionResponseDto(
                LocalDateTime.now(),
                HttpStatus.CONFLICT.value(),
                HttpStatus.CONFLICT.getReasonPhrase(),
                ex.getMessage(),
                req.getRequestURI()
        );



        return ResponseEntity
                .status(HttpStatus.CONFLICT)
                .body(exceptionResponseDto);

    }

    //Validation Error

@ExceptionHandler(MethodArgumentNotValidException.class)
public ResponseEntity<ValidationExceptionResponseDto> handleMethodArgumentNotValidException(MethodArgumentNotValidException ex,
                                                                                             HttpServletRequest req){

    Map<String,String> fieldError = new HashMap<>();

    ex.getBindingResult()
            .getFieldErrors()
            .forEach(error-> fieldError.put(error.getField(), error.getDefaultMessage()));




    ValidationExceptionResponseDto validationExceptionResponseDto = new ValidationExceptionResponseDto(
            LocalDateTime.now(),
            HttpStatus.BAD_REQUEST.value(),
            HttpStatus.BAD_REQUEST.getReasonPhrase(),
            "Validation Error",
            req.getRequestURI(),
            fieldError

    );

     return ResponseEntity
            .status(HttpStatus.BAD_REQUEST)
            .body(validationExceptionResponseDto);





}











    // Runtime Exception

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<ExceptionResponseDto> handleRuntimeException(RuntimeException ex, HttpServletRequest req){

        ExceptionResponseDto exceptionResponseDto = new ExceptionResponseDto(
                LocalDateTime.now(),
                HttpStatus.INTERNAL_SERVER_ERROR.value(),
                HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase(),
                ex.getMessage(),
                req.getRequestURI()
        );



        return ResponseEntity
                .status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(exceptionResponseDto);

    }

    // Generic Exception

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ExceptionResponseDto> handleGenericException(Exception ex, HttpServletRequest req){

        ExceptionResponseDto exceptionResponseDto = new ExceptionResponseDto(
                LocalDateTime.now(),
                HttpStatus.INTERNAL_SERVER_ERROR.value(),
                HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase(),
                ex.getMessage(),
                req.getRequestURI()
        );



        return ResponseEntity
                .status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(exceptionResponseDto);

    }







}
