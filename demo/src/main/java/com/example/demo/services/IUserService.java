package com.example.demo.services;

import com.example.demo.models.UserModel;

import org.springframework.data.domain.PageRequest;

import java.util.List;

public interface IUserService {
    List<UserModel> findAll();
    UserModel create(UserModel model);
    UserModel update(UserModel model);

    void delete(Integer userId);

}