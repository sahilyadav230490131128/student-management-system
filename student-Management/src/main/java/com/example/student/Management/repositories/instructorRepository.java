package com.example.student.Management.repositories;

import com.example.student.Management.entities.Instructor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

@Component
public interface instructorRepository extends CrudRepository<Instructor,Long> {
}
