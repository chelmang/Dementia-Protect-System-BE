package com.example.backend.service.impl;

import com.example.backend.dto.UserRequest;
import com.example.backend.dto.UserResponse;
import com.example.backend.model.User;
import com.example.backend.repository.UserRepository;
import com.example.backend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public List<UserResponse> getAllUser() {
        List<User> userList = userRepository.findAll();
        return userList.stream()
                .map(this::mapUserToUserResponse)
                .collect(Collectors.toList());
    }

    @Override
    public UserResponse getUserById(Integer id) {
        User user = userRepository.getById(id);
        if (user != null) {
            return mapUserToUserResponse(user);
        }
        return null;
    }

    @Override
    public UserResponse addUser(UserRequest userRequest) {
        User newUser = new User();
        newUser.setName(userRequest.getName());
        newUser.setPhone_number(userRequest.getPhone_number());
        newUser.setBirth(userRequest.getBirth());
        newUser.setAddress(userRequest.getAddress());
        newUser.setGender(userRequest.getGender());
        newUser.setOften_place(userRequest.getOften_place());

        User savedUser = userRepository.save(newUser);
        return mapUserToUserResponse(savedUser);
    }

    @Override
    public void updateUser(Integer id, UserRequest userRequest) {
        User user = userRepository.getById(id);
        if (user != null) {
            user.setName(userRequest.getName());
            user.setPhone_number(userRequest.getPhone_number());
            user.setBirth(userRequest.getBirth());
            user.setAddress(userRequest.getAddress());
            user.setGender(userRequest.getGender());
            user.setOften_place(userRequest.getOften_place());

            userRepository.save(user);
        }
    }

    @Override
    public void deleteUser(Integer id) {
        User user = userRepository.getById(id);
        if (user != null) {
            userRepository.delete(user);
        }
    }

    private UserResponse mapUserToUserResponse(User user) {
        UserResponse response = new UserResponse();
        response.setId(user.getId());
        response.setName(user.getName());
        response.setPhone_number(user.getPhone_number());
        response.setBirth(user.getBirth());
        response.setAddress(user.getAddress());
        response.setGender(user.getGender());
        response.setOften_place(user.getOften_place());
        return response;
    }
}
