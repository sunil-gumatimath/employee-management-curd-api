package com.example.employeemanagementsystem.service;

import com.example.employeemanagementsystem.dto.request.EmployeeRequest;
import com.example.employeemanagementsystem.dto.response.EmployeeResponse;

import java.util.List;

public interface EmployeeService {
    EmployeeResponse addEmployee(EmployeeRequest employeeRequest);

    EmployeeResponse findEmployee(String id);

    List<EmployeeResponse> displayAllEmployee();

    EmployeeResponse deleteEmployee(String id);

    EmployeeResponse updateEmployee(String id,EmployeeRequest employeeRequest);
}
