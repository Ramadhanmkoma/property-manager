package com.mkomafamily.property.auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.mkomafamily.property.dto.LoginRequest;
import com.mkomafamily.property.dto.LoginResponse;
import com.mkomafamily.property.model.User;
import com.mkomafamily.property.repository.UserRepository;

@Service
public class AuthService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public LoginResponse login(LoginRequest request) {
        User user = userRepository.findByEmail(request.getEmail()).orElseThrow(
            () -> new UsernameNotFoundException("Invalid Username or Password")
        );

        if (!passwordEncoder.matches(request.getPassword(), user.getPassword())) {
            throw new BadCredentialsException("Invalid Password");
        }

        LoginResponse response = new LoginResponse();
        response.setEmail(user.getEmail());
        response.setRole(user.getRole());
        response.setToken(null);
        response.setMessage("Logged In Successful");

        return response;
    }


}
