package com.example.student.Management.entities;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
@Setter
@Getter
@Entity
@Table(name = "students")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "email")
    private String email;

    @Column(name = "date_of_birth")
    private Date date_of_birth;

    @Column(name = "status")
    private String status;

    @Column(name = "created_at",updatable = false)
    private LocalDateTime created_at;

    @Column(name = "updated_at")
    private LocalDateTime updated_at;

    @Column(name = "phone")
    private String phone;



    @OneToMany(mappedBy = "student",cascade = {CascadeType.PERSIST,CascadeType.REMOVE})
    @ToString.Exclude
    @Builder.Default
    private Set<Enrollment> enrollments = new HashSet<>();

    @OneToMany(mappedBy = "student")
    @ToString.Exclude
    private Set<Result> results = new HashSet<>();

    @Builder.Default
    @ToString.Exclude
    @OneToMany(mappedBy = "student",cascade = CascadeType.PERSIST)
    private Set<Payment> payments = new HashSet<>();

    @ManyToOne
    @JoinColumn(name = "dept_id")
    private Department department;

   public void addEnrollment(Enrollment enrollment)
   {
       enrollments.add(enrollment);
       enrollment.setStudent(this);
   }

   public void addResult(Result result)
   {
      results.add(result);
       result.setStudent(this);
   }

   public void addPayment(Payment payment)
   {
       payments.add(payment);
       payment.setStudent(this);
   }

}
