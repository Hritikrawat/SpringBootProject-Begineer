package com.MajorProject.student.controllers;

import com.MajorProject.student.Entity.Student;
import com.MajorProject.student.service.StudentService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;

import java.util.NoSuchElementException;

@RestController
@RequestMapping("/students")
public class StudentController
{

    @Autowired
    private StudentService studentService;


    @GetMapping("/getStudent/{id}")
    public Student getStudentById(@PathVariable(value = "id") int id)
    {
        Student s = studentService.find(id);
        if(s==null)
            throw new NoSuchElementException("No student foudn with id "+id);
        return s;
    }



    @PostMapping("/save")
    public ResponseEntity<?> addStudent( @Valid @RequestBody  Student stu)
    {
        return ResponseEntity.ok("Saved successfully");
    }

}
