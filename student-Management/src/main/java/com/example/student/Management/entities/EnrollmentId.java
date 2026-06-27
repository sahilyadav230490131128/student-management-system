package com.example.student.Management.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.*;

import java.io.Serializable;

@Embeddable
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class EnrollmentId implements Serializable {
        @Column(name = "student_id")
        private Long studentId;
        @Column(name = "course_id")
        private Long courseId;

}
