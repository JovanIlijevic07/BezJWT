package com.example.demo.models;

import lombok.Builder;
import lombok.Data;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

@Data
@Builder
public class UserModel {
    private Integer id;

    @NotBlank
    private String username;

    private String password;

    @Email
    private String email;
}
