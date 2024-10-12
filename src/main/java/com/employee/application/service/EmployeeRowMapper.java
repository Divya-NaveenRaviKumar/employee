package com.employee.application.service;

import com.employee.domain.model.Employee;
import org.springframework.jdbc.core.RowMapper;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.UUID;

public class EmployeeRowMapper implements RowMapper<Employee> {

    @Override
    public Employee mapRow(ResultSet resultSet, int i) throws SQLException {
        return new Employee(
                UUID.fromString(resultSet.getString("id")),
                resultSet.getString("name")
        );
    }
}