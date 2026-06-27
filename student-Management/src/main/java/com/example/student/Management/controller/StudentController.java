package com.example.student.Management.controller;

import com.example.student.Management.dtos.*;
import com.example.student.Management.mapper.StudentMapper;
import com.example.student.Management.repositories.studentRepository;
import com.example.student.Management.repositories.departmentRepository;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.time.LocalDateTime;

@AllArgsConstructor
@RestController
@RequestMapping("/students")
public class StudentController {
     private studentRepository studentRepository;
     private StudentMapper studentMapper;
    private departmentRepository departmentRepository;

    @GetMapping("/id")
    public ResponseEntity<StudentDto> getStudent(@PathVariable Long id)
    {
          var student = studentRepository.findById(id).orElse(null);
          if(student==null)
          {
              return ResponseEntity.notFound().build();
          }
          return ResponseEntity.ok(studentMapper.toDto(student));
    }
    @GetMapping("/{id}")
    public Iterable<StudentDto> getStudentsByDepartmentId(
            @PathVariable(required = false,name = "dept_id") Integer id)
    {
        if(id!=null)
        {
            return studentRepository.findByDepartmentId(id).stream().map(studentMapper::toDto).toList();
        }
        return studentRepository.findAll().stream().map(studentMapper::toDto).toList();
    }

    /**
    * This method is for adding the student in the department
    * by taking the request body as studentRequestDto class.
    * It checks if that department exist in the institute
    * then it add the student else it throws not found error,
    * Then it returns the ResponseEntity object,
    * This response contains StudentDto in its body.
    * */
    @PostMapping
    public ResponseEntity<StudentDto> admitStudent(
            @Valid @RequestBody StudentRequestDto studentRequestDto,
            UriComponentsBuilder uriBuilder)
    {
      var student = studentMapper.toEntity(studentRequestDto);
      var dept = departmentRepository.findByName(studentRequestDto.getDeptName()).orElse(null);
      if(dept==null)
      {
         return ResponseEntity.notFound().build();
      }
      student.setDepartment(dept);
      student.setCreated_at(LocalDateTime.now());
      student.setUpdated_at(LocalDateTime.now());
      student.setStatus("ACTIVE");
      studentRepository.save(student);
      var studentDto = studentMapper.toDto(student);
      var uri = uriBuilder.path("/students/{id}").buildAndExpand(studentDto.getId()).toUri();
      return ResponseEntity.created(uri).body(studentDto);
    }

    /**
     * This method is for updating the students data
     *
     *
     */
    @PutMapping("/{id}")
    public ResponseEntity<StudentDto> updateStudent(
           @PathVariable(name="id") Long id,
            @RequestBody StudentUpdateDto studentUpdateDto
    )
    {
        var student = studentRepository.findById(id).orElse(null);
        if(student==null)
        {
            return ResponseEntity.notFound().build();
        }
        studentMapper.update(studentUpdateDto,student);
        student.setUpdated_at(LocalDateTime.now());
        studentRepository.save(student);
        return ResponseEntity.ok(studentMapper.toDto(student));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteStudent(@PathVariable Long id)
    {
        var student = studentRepository.findById(id).orElse(null);
        if(student==null)
        {
            return ResponseEntity.notFound().build();
        }
        studentRepository.delete(student);
        return ResponseEntity.noContent().build();
    }

}
