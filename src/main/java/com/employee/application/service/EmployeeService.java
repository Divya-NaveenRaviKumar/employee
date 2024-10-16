package com.employee.application.service;

import com.employee.domain.model.Employee;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class EmployeeService implements EmployeeActions {

    private final JdbcTemplate jdbcTemplate;
    private final ObjectMapper objectMapper = new ObjectMapper();

    public EmployeeService(@Qualifier("employeeJdbcTemplate") JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Employee> getEmployee() {
        //return new ArrayList<>(Arrays.asList("Employee 1", "Employee 2", "Employee 3"));
        var sql = "SELECT * FROM employee";
        /*return jdbcTemplate
                .query(sql,
                        (resultSet, rowNum) -> new Employee(resultSet.getInt("id"), resultSet.getString("name")*//*, objectMapper.readValue(resultSet.getString("details"), Details.class)*//*));*/
        return jdbcTemplate.query(sql, new EmployeeRowMapper());
    }

    @Override
    public Optional<Employee> getEmployeeById(UUID id) {
        var sql = """
                SELECT id, name
                FROM employee
                WHERE id = ?
                """;
        return jdbcTemplate.query(sql, new EmployeeRowMapper(), id)
                .stream()
                .findFirst();
    }

    @Override
    public boolean createEmployee(Employee employee) {
        var sql = "INSERT INTO employee (name, id) VALUES (?, ?)";
        //return jdbcTemplate.update(sql, employee.name(), employee.id()/*, employee.details()*/) == 1;
        return jdbcTemplate.update(sql, employee.name(), employee.id()) == 1;
    }

    @Override
    public boolean deleteEmployee(UUID id) {
        var sql = """
                DELETE FROM employee   
                WHERE id = ?
                """;
        return jdbcTemplate.update(sql, id) == 1;
    }

}
