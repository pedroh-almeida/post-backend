package com.pedro.crudblog.core.exception;

import java.util.ArrayList;
import java.util.List;

import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;

import jakarta.validation.ConstraintViolationException;

import static java.util.stream.Collectors.toList;

import lombok.Getter;

@Getter
public class ApiErrors {

    private List<String> errors;

    public ApiErrors() {
        this.errors = new ArrayList<>();
    }

    public ApiErrors(BindingResult bindingResult) {
        this();
        this.errors.addAll(bindingResult
                .getAllErrors()
                .stream()
                .map(ObjectError::getDefaultMessage)
                .collect(toList()));
    }

    public ApiErrors(PostNotFoundException e) {
        this();
        this.errors.add(e.getMessage());
    }

    public ApiErrors(BusinessException e) {
        this();
        this.errors.add(e.getMessage());
    }

    public ApiErrors(ConstraintViolationException e) {
        this();
        this.errors.add(e.getMessage());
    }

    public ApiErrors(String error) {
        this();
        this.errors.add(error);
    }
}
