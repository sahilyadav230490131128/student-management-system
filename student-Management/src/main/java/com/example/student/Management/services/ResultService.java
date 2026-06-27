package com.example.student.Management.services;

import com.example.student.Management.entities.Result;
import com.example.student.Management.repositories.studentRepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;
import com.example.student.Management.repositories.resultRepository;
@AllArgsConstructor
@Service
public class ResultService {
    private final resultRepository resultRepository;
    private  final studentRepository studentRepository;
    public void addResult()
    {
        var result = Result.builder()
                .semester(5)
                .sgpa(9.8)
                .cgpa(9.5)
                .backlog(0)
                .build();
        var student = studentRepository.findById(1L).orElseThrow();
        result.setStudent(student);
        resultRepository.save(result);
    }
}
