package com.example.coordinate_post.repository;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface FollowMapper {

    void saveFollow(@Param("loginUserId") int loginUserId,
                    @Param("userId") int userId);
}
