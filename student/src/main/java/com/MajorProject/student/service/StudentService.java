package com.MajorProject.student.service;


import com.MajorProject.student.Entity.Student;
import com.MajorProject.student.repository.StudentRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;


@Service
public class StudentService
{

//    @Autowired
    private final StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }


    //saving student
    public boolean saveStudent(Student student)
    {
        Student s = studentRepository.insert(student);
        if(s!=null)
            return true;

        return false;

    }

    public Student find(int id) {
        Student s = studentRepository.findStudentBystudentId(id);
        if(s==null)
            return null;

        return s;
    }


//    public FullSchoolResponse findSchoolsWithStudents(Integer schoolId) {
//        var school = repository.findById(schoolId)
//                .orElse(
//                        School.builder()
//                                .name("NOT_FOUND")
//                                .email("NOT_FOUND")
//                                .build()
//                );
//        var students = client.findAllStudentsBySchool(schoolId);
//        return FullSchoolResponse.builder()
//                .name(school.getName())
//                .email(school.getEmail())
//                .students(students)
//                .build();
//    }
}
