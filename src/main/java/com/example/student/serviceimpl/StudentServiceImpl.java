package com.example.student.serviceimpl;

import com.example.student.entity.Student;
import com.example.student.entity.StudentReading;
import com.example.student.exception.OSException;
import com.example.student.exception.enumexception.ErrorCode;
import com.example.student.mapper.StudentMapper;
import com.example.student.repository.StudentReadingRepo;
import com.example.student.repository.StudentRepo;
import com.example.student.request.StudentReadingRequest;
import com.example.student.request.StudentRequest;
import com.example.student.response.StudentReadingResponse;
import com.example.student.response.StudentResponse;
import com.example.student.response.commons.APIListResponse;
import com.example.student.service.StudentService;
import com.example.student.service.commons.APIListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    StudentRepo studentRepo;
    @Autowired
    StudentMapper studentMapper;
    @Autowired
    StudentReadingRepo studentReadingRepo;
    @Autowired
    APIListService apiListService;

    public StudentServiceImpl() {
    }

    @Transactional
    public StudentResponse createStudent(StudentRequest student) {
        if (student != null) {
            Student studentObj = null;
            if (student != null) {
                studentObj = this.studentMapper.toEntity(student);
                this.studentRepo.save(studentObj);
            }

            return this.studentMapper.toResponse(studentObj);
        } else {
            throw new OSException(ErrorCode.DATA_NOT_FOUND);
        }
    }

    public StudentReadingResponse createStudentReading(StudentReadingRequest studentReadingRequest) throws Exception {
        if (studentReadingRequest != null) {
            StudentReading studentReading = this.studentMapper.toEntityReading(studentReadingRequest);
            this.studentReadingRepo.save(studentReading);
            return this.studentMapper.toResponseReading(studentReading);
        } else {
            throw new OSException(ErrorCode.DATA_NOT_FOUND);
        }
    }

    public APIListResponse<List<StudentResponse>> getAllStudents(int pageNo, int perPage, String sort, String query) {
        Pageable paging = this.apiListService.getPageable(pageNo, perPage, sort);
        APIListResponse<List<StudentResponse>> studentListResponse = new APIListResponse<>();
        List<Student> student = this.studentRepo.findAll();
        Page<Student> studentPage = this.studentRepo.findAll(paging);
        if (!studentPage.isEmpty()) {
            studentListResponse.setList(this.studentMapper.toResonseList(studentPage.getContent()));
            studentListResponse.setTotalElements(studentPage.getTotalElements());
            studentListResponse.setTotalPages(studentPage.getTotalPages());
            studentListResponse.setRequestedPage(studentPage.getNumber() + 1);
            return studentListResponse;
        } else {
            throw new OSException(ErrorCode.DATA_NOT_FOUND);
        }
    }
}
