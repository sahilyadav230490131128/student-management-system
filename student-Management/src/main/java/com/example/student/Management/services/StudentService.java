package com.example.student.Management.services;

import com.example.student.Management.entities.*;
import com.example.student.Management.repositories.*;
import com.example.student.Management.repositories.specifications.studentSpecification;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.time.LocalDate;


@AllArgsConstructor
@Service
public class StudentService {
    private final studentRepository studentRepository;
    private final courseRepository courseRepository;
    private final enrollmentRepository enrollmentRepository;
    private final departmentRepository departmentRepository;
    private final paymentRepository paymentRepository;
    private final resultRepository resultRepository;

    public void addStudents()
    {
        var student = Student.builder()
                .name("Abhisekh")
                .email("Abhi00@gmail.com")
                .build();
        studentRepository.save(student);

    }
    public void addCourses()
    {
        var course = new Course("devops",4);
        courseRepository.save(course);
    }
    public void addEnrollmentExistingStudent()
    {
        var enrollment = Enrollment.builder()
                .enrolled_date(LocalDate.parse("2026-01-03"))
                .build();
        var course = courseRepository.findById(1L).orElseThrow();
        var student = studentRepository.findById(5L).orElseThrow();
        enrollment.setCourse(course);
        enrollment.setStudent(student);
        enrollment.addEnrollmentId();
        enrollmentRepository.save(enrollment);
    }
    public void addDepartmentOfStudent()
    {
        var department = new Department("ME");
        var student = Student.builder()
                .name("sahil")
                .email("sahil@gmail.com")
                .build();
        department.addStudent(student);
        departmentRepository.save(department);
    }

    public void makePayment()
    {
        var payment = Payment.builder()
                .semester(6)
                .total_amount(75000L)
                .paid_amount(60000L)
                .payment_date(LocalDate.parse("2026-01-10"))
                .status("remaining")
                .build();
        var student = studentRepository.findById(1L).orElseThrow();
        payment.setStudent(student);
       paymentRepository.save(payment);

    }
    @Transactional
    public void getStudentResult(Long id)
    {
        var student = studentRepository.findById(id).orElseThrow();
        var result =  resultRepository.findById(student.getId());
        System.out.println(result);
    }
   public void deleteEnrollment()
   {
       var enrollment = enrollmentRepository.findById(new EnrollmentId(1L,1L)).orElseThrow();
       enrollmentRepository.delete(enrollment);
   }

   public void deleteStudent()
   {
       var student = studentRepository.findById(5L).orElseThrow();
       studentRepository.delete(student);
   }
   @Transactional
   public void updateStudentsEmail(String email,Long id )
   {
       var student = studentRepository.findById(id).orElseThrow();
       System.out.println(student);
        studentRepository.updateStudentEmail(email,id);
       //var studentUpdated = studentRepository.findById(id).orElseThrow();
       student.setEmail(email);
       System.out.println(student);

   }
   public void fetchStudentFromDerivedQuery()
   {
       var student = studentRepository.findEnrolledDate(LocalDate.parse("2026-01-10"));
        student.forEach(System.out::println);
       //System.out.println(student);
   }
   public void fetchStudentsBySpecification(String name,String email,Integer minAge,Integer maxAge)
   {

       Specification<Student> spec = (root, query, cb) -> cb.conjunction();
       if(name!=null)
       {
           spec = spec.and(studentSpecification.hasName(name));
       }
       if(email!=null)
       {
           spec = spec.and(studentSpecification.hasEmail(email));
       }
       if(minAge!=null && maxAge!=null)
       {
           spec = spec.and(studentSpecification.hasAgeBetween(minAge, maxAge));
       }
        studentRepository.findAll(spec).forEach(System.out::println);
   }

//   public void deleteRelatedEnrollment()
//   {
//       var student = studentRepository.findById(1L).orElseThrow();
//
//   }
}
