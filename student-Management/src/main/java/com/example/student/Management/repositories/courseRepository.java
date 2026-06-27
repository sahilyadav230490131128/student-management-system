package com.example.student.Management.repositories;

import com.example.student.Management.entities.Course;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

@Component
public interface courseRepository extends CrudRepository<Course,Long> {
}
