package com.example.kodlamaiodevs.exception;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;

@Data
@Builder
public class ErrorResponse {

    private int code;
    private String message;

}
