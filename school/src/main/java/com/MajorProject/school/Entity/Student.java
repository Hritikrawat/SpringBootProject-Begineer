package com.MajorProject.school.Entity;

import jakarta.validation.constraints.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document(collection = "Students")
public class Student {


    @NotNull
    private Integer studentId;

    @NotEmpty(message = "Name Cannot be Empty")
    @Size(min=5, max=10)
    private String firstname;
    private String lastname;

    @NotEmpty(message = "Email Cannot be Empty")
    @Email
    private String email;

    @NotNull(message = "School Id is mandatory")
    private Integer schoolId;

    @NotEmpty(message = "Provide at least one Contact Number")
    private List<String> mobileNo;

    public Student()
    {

    }

    public Integer getStudentId() {
        return studentId;
    }

    public void setStudentId(Integer studentId) {
        this.studentId = studentId;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getSchoolId() {
        return schoolId;
    }

    public void setSchoolId(Integer schoolId) {
        this.schoolId = schoolId;
    }

    public List<String> getMobileNo() {
        return mobileNo;
    }

    public void setMobileNo(List<String> mobileNo) {
        this.mobileNo = mobileNo;
    }
}
