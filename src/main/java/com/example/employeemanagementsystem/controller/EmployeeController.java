package com.example.employeemanagementsystem.controller;

import com.example.employeemanagementsystem.serviceImpl.EmployeeServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class EmployeeController {

    private final EmployeeServiceImpl employeeService;


}
