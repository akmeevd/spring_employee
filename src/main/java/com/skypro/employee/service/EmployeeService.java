package com.skypro.employee.service;

import com.skypro.employee.model.Employee;
import com.skypro.employee.record.EmployeeRequest;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class EmployeeService {
    private final Map<Integer, Employee> employees = new HashMap();

    public EmployeeService() {
    }

    public Collection<Employee> getAllEmployees() {
        return this.employees.values();
    }

    public Employee addEmployee(EmployeeRequest employeeRequest) {
        if (employeeRequest.getFirstName() != null && employeeRequest.getLastName() != null) {
            Employee employee = new Employee(employeeRequest.getFirstName(), employeeRequest.getLastName(), employeeRequest.getDepartment(), employeeRequest.getSalary());
            this.employees.put(employee.getId(), employee);
            return employee;
        } else {
            throw new IllegalArgumentException("Employee name should be set");
        }
    }

    public int getSumSalary() {
        return this.employees.values().stream().mapToInt(Employee::getSalary).sum();
    }

    public int getMinSalary() {
        return employees.values().stream().map(Employee::getSalary).min(Comparator.naturalOrder()).get();
    }

    public int getMaxSalary() {
        return employees.values().stream().map(Employee::getSalary).max(Comparator.naturalOrder()).get();
    }

    public List<Employee> getHighSalary() {
        double averageSalary = employees.values().stream().mapToDouble(Employee::getSalary).average().getAsDouble();
        return employees.values().stream().filter(s-> s.getSalary() >= averageSalary).toList();

    }
}
