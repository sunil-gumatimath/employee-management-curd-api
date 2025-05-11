package com.example.employeemanagementsystem.dto.response;

public record EmployeeResponse(
        int empId,
        String empName,
        String mail,
        int salary,
        String designation
) {
}
