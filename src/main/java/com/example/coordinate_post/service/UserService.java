package com.example.coordinate_post.service;

import com.example.coordinate_post.dto.UserDto;
import com.example.coordinate_post.repository.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserMapper userMapper;

    public List<UserDto> getUsers(int offset, int limit) {
        return userMapper.findUsers(offset, limit);
    }

}
