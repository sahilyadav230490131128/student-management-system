package com.example.student.Management.repositories;

import com.example.student.Management.entities.Student;
import com.example.student.Management.repositories.dtos.StudentSummary;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.List;

@Component
public interface studentRepository extends JpaRepository<Student,Long>, JpaSpecificationExecutor {

    List<Student> findByNameIgnoreCase(String name);
    List<Student> findByNameLikeIgnoreCase(String name);
    List<Student> findByNameEndingWithIgnoreCase(String name);
    List<Student> findByNameStartingWithIgnoreCase(String name);
    List<Student> findByNameContaining(String name);

    List<Student> findByDepartmentId(Integer id);
    Student findByEmail(String email);
//    @Query(value = "SELECT s.* FROM students s JOIN enrollment e ON s.id = e.student_id where e.enrolled_date > :date ",nativeQuery = true)
//    List<Student> findEnrolledDate(@Param("date")LocalDate date);

    @Query("SELECT s.id,s.name FROM Student s JOIN Enrollment e ON s.id = e.enrollmentId.studentId WHERE e.enrolled_date > :date ")
    List<StudentSummary> findEnrolledDate(@Param("date")LocalDate date);

    @Modifying
    @Query("UPDATE Student s SET s.email = :newEmail WHERE s.id = :id")
    void updateStudentEmail(@Param("newEmail")String email,@Param("id")Long id);
}
