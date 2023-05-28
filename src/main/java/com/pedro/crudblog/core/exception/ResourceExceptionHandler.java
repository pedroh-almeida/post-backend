package com.pedro.crudblog.core.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import jakarta.validation.ConstraintViolationException;

@RestControllerAdvice
public class ResourceExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ApiErrors handleValidationException(MethodArgumentNotValidException e) {
        return new ApiErrors(e.getBindingResult());
    }

    @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
    @ResponseStatus(HttpStatus.METHOD_NOT_ALLOWED)
    public ApiErrors handleValidationException(HttpRequestMethodNotSupportedException e) {
        return new ApiErrors(e.getLocalizedMessage());
    }

    @ExceptionHandler(PostNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ApiErrors handleValidationException(PostNotFoundException e) {
        return new ApiErrors(e);
    }

    @ExceptionHandler(BusinessException.class)
    @ResponseStatus(HttpStatus.LENGTH_REQUIRED)
    public ApiErrors handleValidationException(BusinessException e) {
        return new ApiErrors(e);
    }

    @ExceptionHandler(ConstraintViolationException.class)
    @ResponseStatus(HttpStatus.LENGTH_REQUIRED)
    public ApiErrors handleValidationException(ConstraintViolationException e) {
        return new ApiErrors(e.getLocalizedMessage());
    }

}
