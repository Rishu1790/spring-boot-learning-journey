package in.bean.day06springbootexceptionhandling.globalexceptionhandler;

import in.bean.day06springbootexceptionhandling.dto.ExceptionResponseDto;
import in.bean.day06springbootexceptionhandling.dto.ValidationExceptionResponseDto;
import jakarta.servlet.http.HttpServletRequest;
import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {
public ResponseEntity<ExceptionResponseDto> hadleResourceNotFoundException(RuntimeException ex , HttpServletRequest request){

    ExceptionResponseDto exceptionResponseDto = new ExceptionResponseDto(
            LocalDateTime.now(),
            HttpStatus.NOT_FOUND.value(),
            HttpStatus.NOT_FOUND.getReasonPhrase(),
            ex.getMessage(),
            request.getRequestURI()
    );



    return ResponseEntity
            .status(HttpStatus.NOT_FOUND)
            .body(exceptionResponseDto);
}







    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<String>  handleRuntimeException(RuntimeException ex,
                                                          HttpServletRequest request){

        ExceptionResponseDto exceptionResponseDto = new ExceptionResponseDto(
                LocalDateTime.now(),
                HttpStatus.INTERNAL_SERVER_ERROR.value(),
                HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase(),
                ex.getMessage(),
                request.getRequestURI()
        );


        return ResponseEntity
                .status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(ex.getMessage());
    }
    @ExceptionHandler(Exception.class)
    public ResponseEntity<String>  handleGenericException(RuntimeException ex,
                                                          HttpServletRequest request){

        ExceptionResponseDto exceptionResponseDto = new ExceptionResponseDto(
                LocalDateTime.now(),
                HttpStatus.INTERNAL_SERVER_ERROR.value(),
                HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase(),
                ex.getMessage(),
                request.getRequestURI()
        );

    return ResponseEntity
                .status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body("Someting Went Wrong. please Try again later");
    }

    @ExceptionHandler(DuplicateResourceException.class)
    public ResponseEntity<String>  handleDuplicateResourceException(DuplicateResourceException ex,
                                                                    HttpServletRequest request){

        ExceptionResponseDto exceptionResponseDto = new ExceptionResponseDto(
                LocalDateTime.now(),
                HttpStatus.CONFLICT.value(),
                HttpStatus.CONFLICT.getReasonPhrase(),
                ex.getMessage(),
                request.getRequestURI()
        );


    return ResponseEntity
                .status(HttpStatus.CONFLICT)
                .body(ex.getMessage());
    }


    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ValidationExceptionResponseDto>  handleMethodArgumentNotValidException(MethodArgumentNotValidException ex,
                                                                    HttpServletRequest request){

        Map<String,String> fieldErrors = new HashMap<>();

        ex.getBindingResult().getFieldErrors()
                .forEach(error->
                        fieldErrors.put(error.getField(),error.getDefaultMessage()));


        ValidationExceptionResponseDto validationExceptionResponseDto = new ValidationExceptionResponseDto(
                LocalDateTime.now(),
                HttpStatus.BAD_REQUEST.value(),
                HttpStatus.BAD_REQUEST.getReasonPhrase(),
               // ex.getMessage(),
                "Validation Failed",
                request.getRequestURI(),
                fieldErrors


        );


        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(validationExceptionResponseDto);
    }








}
