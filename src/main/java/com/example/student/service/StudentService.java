package com.example.student.service;

import com.example.student.request.StudentReadingRequest;
import com.example.student.request.StudentRequest;
import com.example.student.response.StudentReadingResponse;
import com.example.student.response.StudentResponse;
import com.example.student.response.commons.APIListResponse;

import java.util.List;

public interface StudentService {
    StudentResponse createStudent(StudentRequest student);

    StudentReadingResponse createStudentReading(StudentReadingRequest studentReadingRequest) throws Exception;

    APIListResponse<List<StudentResponse>> getAllStudents(int pageNo, int perPage, String sort, String query);
}
