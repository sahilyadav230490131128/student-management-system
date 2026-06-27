package com.example.student.Management.repositories;

import com.example.student.Management.entities.Department;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public interface departmentRepository extends CrudRepository<Department,Integer> {
    Optional<Department> findByName(String name);
}
