package com.example.student.response;

import lombok.Data;

@Data
public class StudentReadingResponse {
    private int id;
    private long studentId;
    private String reading;

    public StudentReadingResponse() {
    }
}
