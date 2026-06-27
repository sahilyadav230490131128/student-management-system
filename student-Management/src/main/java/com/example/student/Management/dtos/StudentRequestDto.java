package com.example.student.Management.dtos;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.Date;

@AllArgsConstructor
@Getter
@Setter
public class StudentRequestDto {

    @NotBlank(message = "Name is required")
    private String name;
    @NotBlank(message = "Email is required")
    @Email(message = "Email must be valid")
    private String email;
    @Past
    private Date date_of_birth;
    @NotBlank(message = "Department is required")
    private String deptName;
    @Pattern(regexp = "^[1-9]\\d{9}$")
    private String phone;



}
