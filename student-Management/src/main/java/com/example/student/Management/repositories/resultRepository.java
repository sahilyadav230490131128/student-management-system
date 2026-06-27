package com.example.student.Management.repositories;

import com.example.student.Management.entities.Result;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

@Component
public interface resultRepository extends CrudRepository<Result,Long> {
}
