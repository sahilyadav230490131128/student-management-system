package com.example.student.Management.mapper;

import com.example.student.Management.dtos.CourseDto;
import com.example.student.Management.entities.Course;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CourseMapper {

    CourseDto toDto(Course course);
}
