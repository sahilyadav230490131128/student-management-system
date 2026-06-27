package com.example.student.Management.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name="instructors")
public class Instructor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "email")
    private String email;

    @OneToMany(mappedBy = "instructor")
    private Set<Course> courses = new HashSet<>();

    @ManyToOne
    @JoinColumn(name = "department_id")
    private Department department;

    public void addCourse(Course course)
    {
        courses.add(course);
        course.setInstructor(this);
    }

}
