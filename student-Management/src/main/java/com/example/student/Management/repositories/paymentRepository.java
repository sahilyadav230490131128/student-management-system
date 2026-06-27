package com.example.student.Management.repositories;

import com.example.student.Management.entities.Payment;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

@Component
public interface paymentRepository extends CrudRepository<Payment,Long> {
}
