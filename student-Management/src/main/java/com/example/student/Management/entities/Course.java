package com.example.student.Management.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.Set;
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Setter
@Getter
@Entity
@Table(name = "courses")
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id ;

    @Column(name = "name")
    private String name;

    @Column(name = "duration")
    private Integer duration;

    @OneToMany(mappedBy = "course")
    @ToString.Exclude
    private Set<Enrollment> enrollment = new HashSet<>();

    @ManyToOne
    @JoinColumn(name = "instructor_id")
    private Instructor instructor;

    @ManyToOne
    @JoinColumn(name = "dept_id")
    private Department department;

    public Course(String courseName, int duration)
    {
        this.name = courseName;
        this.duration=duration;
    }
    public void addEnrollment(Enrollment enrollment)
    {
        this.enrollment.add(enrollment);
        enrollment.setCourse(this);
    }
}
