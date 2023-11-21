package com.example.student.request;

import lombok.Data;

import java.util.Date;

@Data
public class StudentRequest {
    private String name;
    private String aboutUs;
    private Date dateOfBirth;
    private String gender;
    private String email;
    private String mobileNo;
    private String address;
    private String city;
    private String highestQualification;
    private String passingYear;
    private String board;
    private String university;
    private String companyName;
    private String designation;
    private String totalWorkEx;
    private String timings;
    private String courseChoice;
    private String batch;
    private Date registrationDate = new Date();

    }
