package com.employee.application.service;

import com.employee.domain.model.Employee;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface EmployeeActions {

    List<Employee> getEmployee();

    Optional<Employee> getEmployeeById(UUID id);

    boolean createEmployee(Employee employee);

    boolean deleteEmployee(UUID id);

}
