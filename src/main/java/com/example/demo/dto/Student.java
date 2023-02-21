package com.example.demo.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Data;
@Data
public class Student {
    private String id;
    @NotNull(message = "Make sure firstName not null")
    private String firstName;
    private String lastName;
}
