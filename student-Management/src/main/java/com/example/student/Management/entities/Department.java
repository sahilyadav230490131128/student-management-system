package com.example.student.Management.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.HashSet;
import java.util.Set;

@Getter
@NoArgsConstructor
@Setter
@Entity
@Table(name = "department")
public class Department {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "name")
    private String name;

    @OneToMany(mappedBy = "department")
    @ToString.Exclude
    private Set<Student> students = new HashSet<>();

    @OneToMany(mappedBy = "department")
    private Set<Course> courses = new HashSet<>();

    @OneToMany(mappedBy = "department")
    private Set<Instructor> instructors = new HashSet<>();

    public void addStudent(Student student)
    {
        students.add(student);
        student.setDepartment(this);
    }
    public void addCourse(Course course)
    {

        courses.add(course);
        course.setDepartment(this);
    }

    public void addInstructor(Instructor instructor)
    {
        instructors.add(instructor);
        instructor.setDepartment(this);
    }

    public Department(String name)
    {
        this.name = name;
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" +
                "name = " + name + ")";
    }
}
