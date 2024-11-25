package com.codewithprojects.services.auth;

import com.codewithprojects.Service.AuthService;
import com.codewithprojects.dto.SignupRequest;
import com.codewithprojects.dto.UserDto;
import com.codewithprojects.entity.Role;
import com.codewithprojects.entity.User;
import com.codewithprojects.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    // Check if customer exists by email (returns boolean instead of Optional<User>)
    @Override
    public boolean hasCustomerWithEmail(String email) {
        return userRepository.findByEmail(email).isPresent();  // Return true if user exists
    }

    // Create a new customer
    @Override
    public UserDto createCustomer(SignupRequest signupRequest) {
        User user = new User();
        user.setEmail(signupRequest.getEmail());
        user.setName(signupRequest.getUsername());  // Assigning username
        user.setPassword(passwordEncoder.encode(signupRequest.getPassword()));  // Encode password
        user.setRole(String.valueOf(Role.CUSTOMER));  // Assign default role

        // Save user to the repository
        User savedUser = userRepository.save(user);

        // Map the saved user to UserDto
        return mapToUserDto(savedUser);
    }

    // Validate user credentials
    @Override
    public boolean validateCredentials(String email, String password) {
        Optional<User> userOptional = userRepository.findByEmail(email);  // Fetch user by email
        if (userOptional.isEmpty()) {
            return false;  // Return false if user is not found
        }

        User user = userOptional.get();
        return passwordEncoder.matches(password, user.getPassword());  // Compare passwords
    }

    // Helper method to map User to UserDto
    private UserDto mapToUserDto(User user) {
        UserDto userDto = new UserDto();
        userDto.setId(user.getId());
        userDto.setUsername(user.getUserName());  // Setting username
        userDto.setEmail(user.getEmail());    // Setting email
        return userDto;
    }
}
