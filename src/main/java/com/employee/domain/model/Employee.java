package com.employee.domain.model;

import java.util.UUID;

public record Employee(
        UUID id,
        String name) {
}

