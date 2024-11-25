package com.codewithprojects.dto;

import lombok.Data;

@Data
public class SignupRequest {
    private String Username;
    private String email;
    private String password;
}
