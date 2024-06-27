package com.example.demo.services;

import com.example.demo.entities.User;
import com.example.demo.models.UserModel;
import com.example.demo.repositories.IUserRepository;
import com.example.demo.mappers.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserService {

    @Autowired
    private IUserRepository userRepository;

    public List<UserModel> getAllUsers() {
        return userRepository.findAll().stream()
                .map(UserMapper::toModel)
                .collect(Collectors.toList());
    }

    public UserModel createUser(UserModel userModel) {
        User user = UserMapper.toEntity(userModel);
        user = userRepository.save(user);
        return UserMapper.toModel(user);
    }

    public Optional<UserModel> getUserById(Integer userId) {
        return userRepository.findById(userId)
                .map(UserMapper::toModel);
    }

    public void deleteUser(Integer userId) {
        userRepository.deleteById(userId);
    }
}
