package com.example.student.Management.dtos;

import com.example.student.Management.entities.Course;
import com.example.student.Management.entities.Department;
import com.example.student.Management.entities.Enrollment;
import com.example.student.Management.entities.Result;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class StudentDto {

    private Long id;
    private String name;
    private String email;
    private List<CourseDto> courses;


}
