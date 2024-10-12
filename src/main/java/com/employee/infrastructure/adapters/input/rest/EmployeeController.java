package com.employee.infrastructure.adapters.input.rest;

import com.employee.application.service.EmployeeService;
import com.employee.domain.model.Employee;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/api/employee")
public class EmployeeController {

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping
    public List<Employee> getEmployee() {
        return employeeService.getEmployee();
    }

    @GetMapping("/{id}")
    public Optional<Employee> getEmployeeById(@PathVariable("id") UUID id) {
        return employeeService.getEmployeeById(id);
    }

    @PostMapping
    public Boolean createEmployee(@RequestBody Employee employee) {
        return employeeService.createEmployee(employee);
    }

    @DeleteMapping("/{id}")
    public Boolean deleteEmployee(@PathVariable("id") UUID id) {
        return employeeService.deleteEmployee(id);
    }

}
