package com.example.student.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Entity
@Data
@Table(name = "Student")
public class Student implements Serializable {

    private static final long serialVersionUID = 3684547434302882091L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "Name", nullable = false)
    private String name;
    @Column(name = "AboutUs", nullable = false)
    private String aboutUs;
    @Column(name = "DateOfBirth")
    @Temporal(TemporalType.DATE)
    private Date dateOfBirth;
    @Column(name = "Gender")
    private String gender;
    @Column(name = "Email", unique = true, length = 100)
    private String email;
    @Column(name = "PhoneNumber", length = 20)
    private String mobileNo;
    @Column(name = "Address", length = 255)
    private String address;
    @Column(name = "City", length = 255)
    private String city;
    @Column(name = "HighestQualification", length = 255)
    private String highestQualification;
    @Column(name = "PassingYear", length = 255)
    private String passingYear;
    @Column(name = "Board", length = 255)
    private String board;
    @Column(name = "University", length = 255)
    private String university;
    @Column(name = "CompanyName", length = 255)
    private String companyName;
    @Column(name = "Designation", length = 255)
    private String designation;
    @Column(name = "TotalWorkExperience", length = 255)
    private String totalWorkEx;
    @Column(name = "Timings", length = 255)
    private String timings;
    @Column(name = "CourseChoice", length = 255)
    private String courseChoice;
    @Column(name = "Batch", length = 255)
    private String batch;
    @Column(name = "RegistrationDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date registrationDate = new Date();

}
