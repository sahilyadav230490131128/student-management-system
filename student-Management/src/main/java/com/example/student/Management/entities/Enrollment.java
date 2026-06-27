package com.example.student.Management.entities;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@Builder
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "enrollment")
public class Enrollment {


    @EmbeddedId
    private EnrollmentId enrollmentId;


    @Column(name = "enrolled_date")
    private LocalDate enrolled_date;

    @ManyToOne
    @MapsId("studentId")
    @JoinColumn(name = "student_id")
    private Student student;

    @ManyToOne
    @MapsId("courseId")
    @JoinColumn(name = "course_id")
    private Course course ;

    public void addEnrollmentId()
    {
        enrollmentId  = new EnrollmentId(student.getId(), course.getId());

    }

}
