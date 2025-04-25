package com.MajorProject.school.Service;


import com.MajorProject.school.Entity.School;
import com.MajorProject.school.Entity.Student;
import com.MajorProject.school.FeignClient.StudentClient;
import com.MajorProject.school.Repository.SchoolRepo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
//import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
@Service
public class SchoolService {

    Logger log = LoggerFactory.getLogger(SchoolService.class);

    @Autowired
    private final SchoolRepo schoolRepo;
    private final StudentClient client;

    public SchoolService(SchoolRepo schoolRepo, StudentClient client) {
        this.schoolRepo = schoolRepo;
        this.client = client;
    }



    public boolean saveSchool(School school)
    {

        if (schoolRepo.save(school) != null)
            return true;
        return false;
    }

    public List<School> findAllSchools(){
        return schoolRepo.findAll();

    }

    public Student getStudent(int id){
        Student s = client.getOneStudent(id);
        if(s==null)
                return null;
        return s;


    }

//    public FullSchoolResponse findSchoolsWithStudents(Integer schoolId) {
//        var school = schoolRepo.findById(schoolId)
//                .orElse(
//                        School.builder()
//                                .name("NOT_FOUND")
//                                .email("NOT_FOUND")
//                                .build()
//                );
//
//        List<student>students = client.findAllStudentsBySchool(schoolId);
//        return FullSchoolResponse.builder()
//                .name(school.getName())
//                .email(school.getEmail())
//                .students(students)
//                .build();
//    }


}
