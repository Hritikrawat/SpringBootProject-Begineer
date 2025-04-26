package com.MajorProject.student.controllers;

import com.MajorProject.student.Entity.Student;
import com.MajorProject.student.service.StudentService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;

import java.util.List;
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

    @GetMapping("/getAllStudent")
    public List<Student> getAllSTudents()
    {
        List<Student> s = studentService.findAll();
        if(s.isEmpty())
            throw new NoSuchElementException("No Student Data found");

        return s;
    }




    @PostMapping("/save")
    public ResponseEntity<?> addStudent( @Valid @RequestBody  Student stu)
    {
        if(studentService.saveStudent(stu))
            return ResponseEntity.ok("Saved successfully");

        return ResponseEntity.internalServerError().body("Save Not Saved . Something happened");
    }




//    @PutMapping("/update/{id}")
//    public String updateStudent(@path){
//
//
//    }

    @DeleteMapping("/delete")
    public ResponseEntity<?> delete(@RequestParam(value = "id") Integer id)
    {
        if(studentService.delete(id))
           return  ResponseEntity.ok("Student with Id:"+id+"Deleted Successfully");

        //might be possible ki studen texist hi na karta ho.(add this )
        return ResponseEntity.internalServerError().body("Some Error Happened, Student not deleted");
    }

}
