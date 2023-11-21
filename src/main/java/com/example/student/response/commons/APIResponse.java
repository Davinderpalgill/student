package com.example.student.response.commons;

import com.example.student.exception.OSException;
import com.fasterxml.jackson.annotation.JsonInclude;
import org.springframework.http.HttpStatus;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class APIResponse<T> {
    private Integer status;
    private T data;
    private T error;

    public T getData() {
        return this.data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public Integer getStatus() {
        return this.status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public static <T> APIResponse<T> getSuccessfullResponse(T data) {
        APIResponse<T> response = new APIResponse(data);
        response.status = HttpStatus.OK.value();
        return response;
    }

    public static APIResponse<OSException> getErrorResponse(OSException ex) {
        APIResponse<OSException> response = new APIResponse();
        response.error = ex;
        response.status = ex.getStatus();
        return response;
    }

    public static <T> APIResponse<T> getErrorResponse(T ex) {
        APIResponse<T> response = new APIResponse();
        response.error = ex;
        response.status = 400;
        return response;
    }

    public static <T> APIResponse<T> getErrorResponse(T ex, int status) {
        APIResponse<T> response = new APIResponse();
        response.error = ex;
        response.status = status;
        return response;
    }

    APIResponse() {
    }

    private APIResponse(T data) {
        this.data = data;
    }

    public T getError() {
        return this.error;
    }

    public void setError(T error) {
        this.error = error;
    }
}
