package com.example.student.repository;

import com.example.student.entity.StudentReading;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentReadingRepo extends JpaRepository<StudentReading, Long> {
}
