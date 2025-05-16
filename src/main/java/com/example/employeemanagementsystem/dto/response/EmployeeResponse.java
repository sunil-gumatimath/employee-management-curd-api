package com.example.employeemanagementsystem.dto.response;

public record EmployeeResponse(
        String empId,
        String empName,
        String mail,
        int salary,
        String designation
) {
}
