package com.example.backend.service;

import com.example.backend.dto.UserRequest;
import com.example.backend.dto.UserResponse;

import java.util.List;

public interface UserService {
    List<UserResponse> getAllUser();
    UserResponse getUserById(Integer id);
    UserResponse addUser(UserRequest userRequest);
    void updateUser(Integer id, UserRequest userRequest);
    void deleteUser(Integer id);
}
