package com.MajorProject.school.FeignClient;

import com.MajorProject.school.Entity.Student;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


//@FeignClient(name ="STUDENT-SERVICE" , url="${students.url}")
@FeignClient(name ="student-service", url="http://localhost:7777")
public interface StudentClient {

    @GetMapping("/students/getStudent/{id}")
    Student getOneStudent(@PathVariable(value = "id") int id);


//    @GetMapping("/school/{schoolId}")
//    List<Student> findAllStudentsBySchool(@PathVariable("schoolId") Integer schoolId);
}

