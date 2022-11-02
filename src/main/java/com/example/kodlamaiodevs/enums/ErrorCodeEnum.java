package com.example.kodlamaiodevs.enums;

public enum ErrorCodeEnum {
    USER_NOT_FOUND(404, "Nothing was found for this id"),

    COURSE_NOT_FOUND(404,"Nothing was found for this id"),

    VALIDATION_ERROR(400,"Is not Valid"),
    INTERNAL_SERVER_ERROR(1002, " blank entry is prohibited!!"),
    ;
    private int code;
    private final String message;

    ErrorCodeEnum(int code, String message) {
        this.code = code;
        this.message = message;
    }
    public int getCode() {
        return code;
    }
    public String getMessage() {
        return message;
    }
}
