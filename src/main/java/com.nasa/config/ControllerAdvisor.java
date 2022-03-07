package com.nasa.config;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;
import java.util.stream.Collectors;

@RestControllerAdvice
public class ControllerAdvisor {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.UNPROCESSABLE_ENTITY)
    public List<ObjectError> ValidExceptionHandler(MethodArgumentNotValidException exception){
        return exception.getFieldErrors().stream().map(object -> new ObjectError(object.getField(),
                object.getDefaultMessage())).collect(Collectors.toList());
    }
}
