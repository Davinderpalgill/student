package com.example.student.controllers;

import com.example.student.request.StudentReadingRequest;
import com.example.student.request.StudentRequest;
import com.example.student.response.StudentReadingResponse;
import com.example.student.response.StudentResponse;
import com.example.student.response.commons.APIListResponse;
import com.example.student.response.commons.APIResponse;
import com.example.student.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StudentController {
    @Autowired
    StudentService studentService;

    public StudentController() {
    }

    @PostMapping(
            value = {"/createStudent"},
            consumes = {"application/json"},
            produces = {"application/json"}
    )
    public StudentResponse createStudent(@RequestBody StudentRequest student) {
        StudentResponse studentResponse = this.studentService.createStudent(student);
        return studentResponse;
    }

    @PostMapping(
            value = {"/createStudentReading"},
            consumes = {"application/json"},
            produces = {"application/json"}
    )
    public StudentReadingResponse createStudentReading(@RequestBody StudentReadingRequest studentReadingRequest) throws Exception {
        StudentReadingResponse studentReadingResponse = this.studentService.createStudentReading(studentReadingRequest);
        return studentReadingResponse;
    }

    @GetMapping(
            value = {"/students"},
            produces = {"application/json"}
    )
    public APIResponse<APIListResponse<List<StudentResponse>>> getStudents(@RequestParam(value = "pageNo",defaultValue = "1") int pageNo, @RequestParam(value = "perPage",defaultValue = "20") int perPage, @RequestParam(value = "sort",required = false) String sort, @RequestParam(value = "query",required = false) String query) {
        APIListResponse<List<StudentResponse>> studentResponseList = this.studentService.getAllStudents(pageNo, perPage, sort, query);
        return APIResponse.getSuccessfullResponse(studentResponseList);
    }

    @GetMapping("/test")
    public String test(){
        return "working";
    }
}
