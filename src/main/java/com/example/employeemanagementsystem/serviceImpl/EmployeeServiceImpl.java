package com.example.employeemanagementsystem.serviceImpl;

import com.example.employeemanagementsystem.dto.request.EmployeeRequest;
import com.example.employeemanagementsystem.dto.response.EmployeeResponse;
import com.example.employeemanagementsystem.entity.Employee;
import com.example.employeemanagementsystem.exception.UserNotFoundById;
import com.example.employeemanagementsystem.exception.UserObjectNotCreated;
import com.example.employeemanagementsystem.mapper.EmployeeMapper;
import com.example.employeemanagementsystem.repository.EmployeeRepository;
import com.example.employeemanagementsystem.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;
    private final EmployeeMapper employeeMapper;

    @Override
    public EmployeeRequest addEmployee(EmployeeRequest employeeRequest) {

       if (employeeRequest == null){
           throw new UserObjectNotCreated("Employee request cannot be null");
       }
        Employee employee = new Employee();
        employee.setEmpName(employeeRequest.empName());
        employee.setMail(employeeRequest.mail());
        employee.setSalary(employeeRequest.salary());
        employee.setDesignation(employeeRequest.designation());

        employeeRepository.save(employee);

        return employeeRequest;
    }

    @Override
    public EmployeeResponse findEmployee(String id) {
        Employee employee = employeeRepository.findById(id)
                .orElseThrow(()->new UserNotFoundById("Employee with id \" + id + \" not found"));
        return employeeMapper.toResponse(employee);
    }
}
