package com.example.student.Management.entities;

import jakarta.persistence.*;
import lombok.*;

@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "result")
public class Result {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "semester")
    private Integer semester;

    @Column(name = "sgpa")
    private Double sgpa;

    @Column(name = "cgpa")
    private Double cgpa;

    @Column(name = "backlog")
    private Integer backlog;

    @ManyToOne
    @JoinColumn(name = "student_id")
    private Student student;



}
