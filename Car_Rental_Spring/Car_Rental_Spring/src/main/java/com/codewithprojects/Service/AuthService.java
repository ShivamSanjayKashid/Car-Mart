package com.codewithprojects.Service;

import com.codewithprojects.dto.SignupRequest;
import com.codewithprojects.dto.UserDto;

public interface AuthService {

    // Check if customer exists by email
    boolean hasCustomerWithEmail(String email);

    // Create a new customer
    UserDto createCustomer(SignupRequest signupRequest);

    // Validate user credentials
    boolean validateCredentials(String email, String password);
}
