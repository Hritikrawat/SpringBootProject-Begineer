package com.MajorProject.school.Repository;

import com.MajorProject.school.Entity.School;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface SchoolRepo extends MongoRepository<School,Integer> {

    @Override
    Optional<School> findById(Integer integer);
}
