package com.example.demo.services;

import com.example.demo.entities.User;
import com.example.demo.models.UserModel;
import com.example.demo.models.UserPageModel;
import com.example.demo.repositories.IUserRepository;
import com.example.demo.mappers.UserMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserService implements IUserService {
    private final IUserRepository userRepository;

    @Override
    public List<UserModel> findAll() {
        var result = userRepository.findAll();
        return UserMapper.toModelList(result);
    }

    @Override
    public UserPageModel findPagedList(PageRequest pageRequest) {
        var result = userRepository.findAll(pageRequest);
        return UserMapper.toModelPagedList(result);
    }

    @Override
    public UserModel create(UserModel model) {
        var entity = UserMapper.toEntity(model);

        var result = userRepository.save(entity);

        return UserMapper.toModel(result);
    }

    @Override
    public UserModel update(UserModel model) {
        var entity = UserMapper.toEntity(model);

        var result = userRepository.save(entity);

        return UserMapper.toModel(result);
    }


}