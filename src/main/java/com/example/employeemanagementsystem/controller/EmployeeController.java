package com.example.employeemanagementsystem.controller;

import com.example.employeemanagementsystem.dto.request.EmployeeRequest;
import com.example.employeemanagementsystem.dto.response.EmployeeResponse;
import com.example.employeemanagementsystem.serviceImpl.EmployeeServiceImpl;
import com.example.employeemanagementsystem.utility.ResponseStructure;
import com.example.employeemanagementsystem.utility.RestResponseBuilder;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
public class EmployeeController {

    private final EmployeeServiceImpl employeeService;

    @PostMapping("/employee/add")
    public ResponseEntity<ResponseStructure<EmployeeRequest>> addEmployee(@RequestBody EmployeeRequest employeeRequest){
        EmployeeRequest addEmployee = employeeService.addEmployee(employeeRequest);
        return RestResponseBuilder.created("Employee object Created",addEmployee, HttpStatus.CREATED);
    }

    @GetMapping("/employee/find/{id}")
    public ResponseEntity<ResponseStructure<EmployeeResponse>> findEmployee(@PathVariable String id){
        EmployeeResponse findEmployee = employeeService.findEmployee(id);
        return RestResponseBuilder.ok("Employee with id = "+id+" found",findEmployee,HttpStatus.OK);
    }

    @GetMapping("/employee/display")
    public ResponseEntity<ResponseStructure<List<EmployeeResponse>>> displayAllEmployee(){
        List<EmployeeResponse> displayAllEmployee = employeeService.displayAllEmployee();
        return RestResponseBuilder.ok("All employee fetched", displayAllEmployee,HttpStatus.OK);
    }
}
