package com.example.demo.mappers;

import com.example.demo.entities.User;
import com.example.demo.models.UserModel;

import java.util.List;
import java.util.stream.Collectors;

public class UserMapper {

    public static UserModel toModel(User user) {
        if (user == null) {
            return null;
        }
        return UserModel.builder()
                .id(user.getId())
                .username(user.getUsername())
                .password(user.getPassword())
                .email(user.getEmail())
                .build();
    }

    public static User toEntity(UserModel userModel) {
        if (userModel == null) {
            return null;
        }
        User user = new User();
        user.setId(userModel.getId());
        user.setUsername(userModel.getUsername());
        user.setPassword(userModel.getPassword());
        user.setEmail(userModel.getEmail());
        return user;
    }

    public static List<UserModel> toModelList(List<User> users) {
        return users.stream()
                .map(UserMapper::toModel)
                .collect(Collectors.toList());
    }
}
