package com.example.student.mapper;

import com.example.student.entity.Student;
import com.example.student.entity.StudentReading;
import com.example.student.request.StudentReadingRequest;
import com.example.student.request.StudentRequest;
import com.example.student.response.StudentReadingResponse;
import com.example.student.response.StudentResponse;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        componentModel = "spring"
)
public interface StudentMapper {
    List<StudentResponse> toResonseList(List<Student> student);

    Student toEntity(StudentRequest studentRequest);

    StudentResponse toResponse(Student student);

    StudentReading toEntityReading(StudentReadingRequest studentReadingRequest);

    StudentReadingResponse toResponseReading(StudentReading studentReading);
}
