package com.example.student.Management.mapper;

import com.example.student.Management.dtos.CourseDto;
import com.example.student.Management.dtos.StudentDto;
import com.example.student.Management.dtos.StudentRequestDto;
import com.example.student.Management.dtos.StudentUpdateDto;
import com.example.student.Management.entities.Enrollment;
import com.example.student.Management.entities.Student;

import org.mapstruct.*;

import java.util.List;
import java.util.Set;

@Mapper(componentModel = "spring")
public interface StudentMapper {
     @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void update(StudentUpdateDto studentUpdateDto, @MappingTarget Student student);
    @Mapping(target = "courses",source = "enrollments",qualifiedByName = "enrollmentsToCourse")
    StudentDto toDto(Student student);

    @Mapping(target = "department.name",source = "deptName")
    @Mapping(target = "date_of_birth",source = "date_of_birth")
    Student toEntity(StudentRequestDto studentRequestDto);
    @Named("enrollmentsToCourse")
    default List<CourseDto> enrollmentToCourse(Set<Enrollment> enrollments)
    {
        if(enrollments==null)
        {
            return List.of();
        }
        return enrollments.stream().map(e->e.getCourse()).map(c->new CourseDto(c.getId(),c.getName())).toList();
    }
}
