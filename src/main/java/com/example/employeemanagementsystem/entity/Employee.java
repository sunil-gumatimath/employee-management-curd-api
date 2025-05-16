package com.example.employeemanagementsystem.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Employee {

    @Id
    @Column(name = "empId", nullable = false)
    @GeneratedValue(strategy = GenerationType.UUID)
    private String empId;  // Changed from int to String for UUID

    @Column(name = "empName", nullable = false)
    private String empName;

    @Column(name = "mail", nullable = false)
    private String mail;

    @Column(name = "salary", nullable = false)
    private int salary;

    @Column(name = "designation", nullable = false)
    private String designation;  // Fixed capitalization

}
