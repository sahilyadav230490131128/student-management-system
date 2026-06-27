package com.example.student.Management;

import com.example.student.Management.entities.Course;
import com.example.student.Management.entities.Enrollment;
import com.example.student.Management.entities.Result;
import com.example.student.Management.entities.Student;
import com.example.student.Management.repositories.courseRepository;
import com.example.student.Management.repositories.departmentRepository;
import com.example.student.Management.repositories.enrollmentRepository;
import com.example.student.Management.repositories.studentRepository;
import com.example.student.Management.services.ResultService;
import com.example.student.Management.services.StudentService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.time.LocalDate;
import java.util.Date;

@SpringBootApplication
public class StudentManagementApplication {

	public static void main(String[] args)
	{
		ApplicationContext context = SpringApplication.run(StudentManagementApplication.class);
		//var resultService = context.getBean(departmentRepository.class);
		//System.out.println(resultService.findByName("CE"));

//		var studentService = context.getBean(StudentService.class);
//		 studentService.getStudentResult(1L);
	}

}
