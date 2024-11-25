package com.codewithprojects.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Setter;

@Entity
public class User {

    @Setter
    @Id
    private Long id;
    private String email;
    private String password;
    private String role; // Assuming role is a String (e.g., "USER", "ADMIN")
    private String Username;

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getUserName() {  // This is the getter for the `name` field
        return Username;
    }

    public void setName(String name) {
        this.Username = Username;
    }
}
