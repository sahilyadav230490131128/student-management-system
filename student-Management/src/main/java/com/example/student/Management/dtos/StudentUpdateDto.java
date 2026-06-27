package com.example.student.Management.dtos;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.time.LocalDate;

@Data
public class StudentUpdateDto {

    private String name;
    @Email
    private String email;
    @Past
    private LocalDate date_of_birth;
    @Pattern(regexp = "^[1-9]\\d{9}$")
    private String phone;

    private String status;

}
