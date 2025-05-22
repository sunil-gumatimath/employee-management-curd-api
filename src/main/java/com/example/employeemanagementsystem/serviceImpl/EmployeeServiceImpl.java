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

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;
    private final EmployeeMapper employeeMapper;

    @Override
    public EmployeeResponse addEmployee(EmployeeRequest employeeRequest) {
        if (employeeRequest == null){
            throw new UserObjectNotCreated("Employee request cannot be null");
        }
        Employee employee = new Employee();
        employee.setEmpName(employeeRequest.empName());
        employee.setMail(employeeRequest.mail());
        employee.setSalary(employeeRequest.salary());
        employee.setDesignation(employeeRequest.designation());

        employeeRepository.save(employee);

        return employeeMapper.toResponse(employee);
    }

    @Override
    public EmployeeResponse findEmployee(String id) {
        Employee employee = employeeRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundById("Employee with id = " + id + " not found"));
        return employeeMapper.toResponse(employee);
    }

    @Override
    public List<EmployeeResponse> displayAllEmployee() {
        List<Employee> employees = employeeRepository.findAll();
        return employees.stream()
                .map(employeeMapper::toResponse)
                .toList();
    }

    @Override
    public EmployeeResponse deleteEmployee(String id) {
        Employee employee = employeeRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundById("Employee with id " + id + " not found"));

        employeeRepository.delete(employee);
        return employeeMapper.toResponse(employee);
    }

    @Override
    public EmployeeResponse updateEmployee(String id, EmployeeRequest employeeRequest) {
        Employee employee = employeeRepository.findById(id)
                .orElseThrow(()-> new UserNotFoundById("Employee not found with id ="+id));

        employee.setEmpName(employeeRequest.empName());
        employee.setMail(employeeRequest.empName());
        employee.setSalary(employeeRequest.salary());
        employee.setDesignation(employeeRequest.designation());

        return employeeMapper.toResponse(employee);
    }
}