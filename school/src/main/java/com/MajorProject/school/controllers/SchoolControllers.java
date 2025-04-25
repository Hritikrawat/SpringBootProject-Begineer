package com.MajorProject.school.controllers;

import com.MajorProject.school.Entity.School;
import com.MajorProject.school.Entity.Student;
import com.MajorProject.school.Service.SchoolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/school")
public class SchoolControllers {



    @Autowired
    private final SchoolService service;

    public SchoolControllers(SchoolService service) {
        this.service = service;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void save(@RequestBody School school) {
        service.saveSchool(school);
    }

    @GetMapping
    public ResponseEntity<List<School>> findAllSchools() {
        return ResponseEntity.ok(service.findAllSchools());
    }

    @GetMapping("/studentId/{id}")
    public Student studentFromSchool(@PathVariable int id){
        Student s = service.getStudent(id);
        if(s!=null)
            return s;
        return new Student();
    }


//    public ResponseEntity<FullSchoolResponse> findAllStudentsBySchoolId(@PathVariable("school-id") Integer schoolId
//    ) {
//        return ResponseEntity.ok(service.findSchoolsWithStudents(schoolId));
//    }

}