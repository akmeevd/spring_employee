package com.skypro.employee.controller;

import com.skypro.employee.model.Employee;
import com.skypro.employee.record.EmployeeRequest;
import com.skypro.employee.service.EmployeeService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.List;

@RestController
public class EmployeeController {
    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping({"/employees"})
    public Collection<Employee> getAllEmployees() {
        return this.employeeService.getAllEmployees();
    }

    @PostMapping({"/employees"})
    public Employee createEmployee(@RequestBody EmployeeRequest employeeRequest) {
        return this.employeeService.addEmployee(employeeRequest);
    }

    @GetMapping({"/employees/salary/sum"})
    public int getSumSalary() {
        return this.employeeService.getSumSalary();
    }

    @GetMapping("/employees/salary/min")
    public int getMinSalary() {
        return employeeService.getMinSalary();
    }

    @GetMapping("/employees/salary/max")
    public int getMaxSalary() {
        return employeeService.getMaxSalary();
    }

    @GetMapping("/employees/high-salary")
    public List<Employee> getHighSalary() {
        return employeeService.getHighSalary();
    }
}
