package com.example.employeemanagementsystem.controller;

import com.example.employeemanagementsystem.dto.request.EmployeeRequest;
import com.example.employeemanagementsystem.dto.response.EmployeeResponse;
import com.example.employeemanagementsystem.entity.Employee;
import com.example.employeemanagementsystem.service.EmployeeService;
import com.example.employeemanagementsystem.utility.ResponseStructure;
import com.example.employeemanagementsystem.utility.RestResponseBuilder;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/employees")
public class EmployeeController {

    private final EmployeeService employeeService;

    @PostMapping("/add")
    public ResponseEntity<ResponseStructure<EmployeeResponse>> addEmployee(@RequestBody EmployeeRequest employeeRequest){
        EmployeeResponse addEmployee = employeeService.addEmployee(employeeRequest);
        return RestResponseBuilder.created("Employee object created", addEmployee, HttpStatus.CREATED);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<ResponseStructure<EmployeeResponse>> findEmployee(@PathVariable String id){
        EmployeeResponse findEmployee = employeeService.findEmployee(id);
        return RestResponseBuilder.ok("Employee with id = " + id + " found", findEmployee, HttpStatus.OK);
    }

    @GetMapping("/display")
    public ResponseEntity<ResponseStructure<List<EmployeeResponse>>> displayAllEmployee(){
        List<EmployeeResponse> displayAllEmployee = employeeService.displayAllEmployee();
        return RestResponseBuilder.ok("All employees fetched", displayAllEmployee, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<ResponseStructure<EmployeeResponse>> deleteEmployee(@PathVariable String id){
        EmployeeResponse employeeResponse = employeeService.deleteEmployee(id);
        return RestResponseBuilder.ok("Employee with "+id,employeeResponse,HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<ResponseStructure<EmployeeResponse>> updateEmployee(
            @PathVariable String id,
            @RequestBody EmployeeRequest employeeRequest){

        EmployeeResponse employeeResponse = employeeService.updateEmployee(id,employeeRequest);
        return RestResponseBuilder.success(HttpStatus.OK,"Employee Updated successfully",employeeResponse);
    }
}