package com.example.student.Management.entities;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "payments")
public class Payment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "semester")
    private Integer semester;

    @Column(name = "total_amount")
    private Long total_amount;

    @Column(name = "paid_amount")
    private Long paid_amount;

    @Column(name = "payment_date")
    private LocalDate payment_date;

    @Column(name = "status")
    private String status;

    @ManyToOne
    @JoinColumn(name = "student_id")
    private Student student;


}
