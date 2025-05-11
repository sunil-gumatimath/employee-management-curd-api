package com.example.employeemanagementsystem.mapper;

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
}
