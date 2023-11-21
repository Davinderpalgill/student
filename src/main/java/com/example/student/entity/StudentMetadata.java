package com.example.student.entity;

import com.example.student.constants.enums.StudentState;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
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
public class StudentMetadata implements Serializable {

    private static final long serialVersionUID = -3688399874656575967L;
    @Id
    @GeneratedValue(
            strategy = GenerationType.IDENTITY
    )
    @Column(
            name = "id"
    )
    private int id;
    @Column(
            name = "studentId"
    )
    private long studentId;
    @Enumerated(EnumType.STRING)
    private StudentState state;


}
