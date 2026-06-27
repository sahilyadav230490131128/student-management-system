package com.example.student.Management.repositories;

import com.example.student.Management.entities.Enrollment;
import com.example.student.Management.entities.EnrollmentId;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;


@Component
public interface enrollmentRepository extends CrudRepository<Enrollment, EnrollmentId> {
}
