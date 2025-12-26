package com.example.coordinate_post.service;

import com.example.coordinate_post.repository.FollowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FollowService {

    @Autowired
    FollowMapper followMapper;
    public void saveFollow(Integer loginUserId, Integer userId) {
        followMapper.saveFollow(loginUserId, userId);
    }

}
