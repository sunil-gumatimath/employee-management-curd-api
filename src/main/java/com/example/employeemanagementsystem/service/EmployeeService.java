package com.example.employeemanagementsystem.service;

import com.example.employeemanagementsystem.dto.request.EmployeeRequest;
import com.example.employeemanagementsystem.dto.response.EmployeeResponse;

import java.util.List;

public interface EmployeeService {
    EmployeeRequest addEmployee(EmployeeRequest employeeRequest);

    EmployeeResponse findEmployee(String id);

    List<EmployeeRequest> displayAllEmployee();
}
