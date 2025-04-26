package com.MajorProject.student.repository;

import com.MajorProject.student.Entity.Student;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends MongoRepository<Student , Integer>
{

    Student findStudentBystudentId(int id);

    long deleteBystudentId(int id);
}
