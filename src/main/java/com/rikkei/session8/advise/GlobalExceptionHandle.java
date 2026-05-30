package com.rikkei.session8.advise;

import com.rikkei.session8.exception.BookAlreadyReturnException;
import com.rikkei.session8.exception.ResourceNotFoundException;
import com.rikkei.session8.model.dto.response.ApiDataResponse;
import com.rikkei.session8.model.dto.response.ErrorsResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;
import java.util.Map;
import java.util.TreeMap;

@RestControllerAdvice

public class GlobalExceptionHandle {
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ApiDataResponse<Map<String, String>>> handleMethodArgumentNotValidException(MethodArgumentNotValidException ex) {
        Map<String,String>  errors = new TreeMap<>();
        for(int i=0;i<ex.getBindingResult().getFieldErrors().size();i++){
            ObjectError objects=ex.getAllErrors().get(i);
            errors.put("Errors :"+(i+1),objects.getDefaultMessage());
        }
        return new ResponseEntity<>(new ApiDataResponse<>(
                false,
                "Erors data",
                null,
                errors,
                HttpStatus.BAD_REQUEST
        ),HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ErrorsResponse> handleResourceNotFoundException(ResourceNotFoundException ex) {
        return new ResponseEntity<>(new ErrorsResponse(
                false,
                "Errors data",
                LocalDateTime.now()
        ),HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler(BookAlreadyReturnException.class)
    public ResponseEntity<ErrorsResponse> handleBookAlreadyReturnException(BookAlreadyReturnException ex) {
        return new ResponseEntity<>(new ErrorsResponse(
                false,
                "Fail to return",
                LocalDateTime.now()
        ),HttpStatus.BAD_REQUEST);
    }
}
