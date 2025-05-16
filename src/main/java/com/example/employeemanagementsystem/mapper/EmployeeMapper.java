package com.example.employeemanagementsystem.mapper;

import com.example.employeemanagementsystem.dto.request.EmployeeRequest;
import com.example.employeemanagementsystem.dto.response.EmployeeResponse;
import com.example.employeemanagementsystem.entity.Employee;
import org.springframework.stereotype.Component;

@Component
public class EmployeeMapper {
    public EmployeeResponse toResponse(Employee employee){
        if (employee == null){
            return null;
        }
        return new EmployeeResponse(
                employee.getEmpId(),
                employee.getEmpName(),
                employee.getMail(),
                employee.getSalary(),
                employee.getDesignation()
        );
    }

    public Employee toEntity(EmployeeRequest request){
        if (request == null)
            return null;

        Employee employee = new Employee();
        employee.setEmpName(request.empName());
        employee.setMail(request.mail());
        employee.setSalary(request.salary());
        employee.setDesignation(request.designation());

        return employee;
    }
}