package com.example.kodlamaiodevs.exception;

import com.example.kodlamaiodevs.enums.ErrorCodeEnum;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import javax.persistence.EntityNotFoundException;
import javax.validation.ConstraintViolationException;

@RestControllerAdvice
public class ExceptionHandling {

    @ExceptionHandler(EntityNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ErrorResponse handleCustomException(EntityNotFoundException e) {
        return ErrorResponse.builder()
                .code(ErrorCodeEnum.USER_NOT_FOUND.getCode())
                .message(ErrorCodeEnum.USER_NOT_FOUND.getMessage())
                .build();
    }

    @ExceptionHandler(ConstraintViolationException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ErrorResponse ConstraintViolationException(ConstraintViolationException e) {
        return ErrorResponse.builder()
                .code(ErrorCodeEnum.INTERNAL_SERVER_ERROR.getCode())
                .message(ErrorCodeEnum.INTERNAL_SERVER_ERROR.getMessage())
                .build();
    }

    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorResponse MethodArgumentTypeMismatchException(MethodArgumentTypeMismatchException e) {
        return ErrorResponse.builder()
                .code(ErrorCodeEnum.VALIDATION_ERROR.getCode())
                .message(ErrorCodeEnum.VALIDATION_ERROR.getMessage())
                .build();
    }
}
