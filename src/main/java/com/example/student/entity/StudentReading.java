package com.example.student.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

import java.io.Serializable;

@Entity
@Data
@Table(
        name = "studentReading"
)
public class StudentReading implements Serializable {

    private static final long serialVersionUID = 6556432336473104279L;
    @Id
    @GeneratedValue(
            strategy = GenerationType.IDENTITY
    )
    @Column(
            name = "id"
    )
    private Long id;
    @Column(
            name = "studentId"
    )
    private long studentId;
    @Column(
            name = "reading"
    )
    private String reading;

}
