package com.MajorProject.school.DTO;

import com.MajorProject.school.Entity.Student;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class SchoolResponse {

    @Autowired
    private Student student;
    private String school_name;

    private String school_email;

    List<Student> students;
}
