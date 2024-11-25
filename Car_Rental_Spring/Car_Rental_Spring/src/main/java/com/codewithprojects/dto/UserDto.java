package com.codewithprojects.dto;

import lombok.Data;

@Data
public class UserDto {
    private Long id;          // User ID
    private String username;  // Changed 'name' to 'username' for consistency
    private String email;     // User's email

    // Constructor for initializing all fields (id, username, email)
    public UserDto(Long id, String username, String email) {
        this.id = id;
        this.username = username;
        this.email = email;
    }

    // Constructor for initializing only username and email (without id)
    public UserDto(String username, String email) {
        this.username = username;
        this.email = email;
    }

    // Default constructor (required by frameworks like Spring)
    public UserDto() {}
}
