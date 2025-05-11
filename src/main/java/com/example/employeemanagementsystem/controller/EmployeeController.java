package com.example.employeemanagementsystem.controller;

import com.example.employeemanagementsystem.dto.request.EmployeeRequest;
import com.example.employeemanagementsystem.serviceImpl.EmployeeServiceImpl;
import com.example.employeemanagementsystem.utility.ResponseStructure;
import com.example.employeemanagementsystem.utility.RestResponseBuilder;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class EmployeeController {

    private final EmployeeServiceImpl employeeService;

    @PostMapping("/employee/add")
    public ResponseEntity<ResponseStructure<EmployeeRequest>> addEmployee(@RequestBody EmployeeRequest employeeRequest){
        EmployeeRequest employeeRequest1 = employeeService.addEmployee(employeeRequest);
        return RestResponseBuilder.created("Employee object Created",employeeRequest1, HttpStatus.CREATED);
    }
}
