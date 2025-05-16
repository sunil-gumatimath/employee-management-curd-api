package com.example.employeemanagementsystem.dto.request;

public record EmployeeRequest(
    String empName,
    String mail,
    int salary,
    String designation
) {
}
