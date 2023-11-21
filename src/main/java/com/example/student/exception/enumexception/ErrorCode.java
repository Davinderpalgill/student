package com.example.student.exception.enumexception;

import org.springframework.http.HttpStatus;

public enum ErrorCode {
    BAD_REQUEST(HttpStatus.BAD_REQUEST.value(), "BAD_REQUEST", "Request failed due to providing bad input. "),
    INVALID_SORT_ORDER_REQUEST(HttpStatus.BAD_REQUEST.value(), "INVALID_SORT_ORDER_REQUEST", "Invalid list sort order request."),
    INVALID_PAGE_REQUEST(HttpStatus.BAD_REQUEST.value(), "INVALID_PAGE_REQUEST", "Invalid page request."),
    DATA_NOT_FOUND(HttpStatus.NOT_FOUND.value(), "DATA_NOT_FOUND", "Requested data, not found."),
    FEIGN_SERVICE_UNAVAILABLE(HttpStatus.NO_CONTENT.value(), "FEIGN_SERVICE_UNAVAILABLE", "Server not found at eureka service"),
    DATA_ALREADY_EXIST(HttpStatus.CONFLICT.value(), "DATA_ALREADY_EXIST", "Data already exist: "),
    UNKNOWN_ERROR(HttpStatus.INTERNAL_SERVER_ERROR.value(), "UNKNOWN_ERROR", "Something went wrong, try again");

    private final int status;
    private final String errorCode;
    private final String message;

    public int getStatus() {
        return this.status;
    }

    public String getErrorCode() {
        return this.errorCode;
    }

    public String getMessage() {
        return this.message;
    }

    private ErrorCode(final int status, final String errorCode, final String message) {
        this.status = status;
        this.errorCode = errorCode;
        this.message = message;
    }
}
