package com.example.learn.restApi.user.service.impl;

import com.example.learn.restApi.user.entity.User;
import com.example.learn.restApi.user.service.UserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Override
    public User getUser(long id) {
        User user = new User();
        user.setId(id);
        return user;
    }
}
