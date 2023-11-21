package com.example.student.exception;

import com.example.student.exception.enumexception.ErrorCode;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@JsonIgnoreProperties({"cause", "stackTrace", "suppressed", "localizedMessage"})
@Data
public class OSException extends RuntimeException {
    private String code;
    private int status;
    private String message;

    public OSException(ErrorCode errorCode) {
        super(errorCode.getMessage(), (Throwable)null, true, false);
        this.code = errorCode.getErrorCode();
        this.status = errorCode.getStatus();
        this.message = errorCode.getMessage();
    }

    public OSException(ErrorCode error, String msg) {
        super(error.getMessage(), (Throwable)null, true, false);
        this.code = error.getErrorCode();
        this.status = error.getStatus();
        String var10001 = error.getMessage();
        this.message = var10001 + msg;
    }

}
