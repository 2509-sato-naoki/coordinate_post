package com.example.coordinate_post.repository;

import com.example.coordinate_post.dto.UserDto;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface UserMapper {
    List<UserDto> findUsers(@Param("offset") int offset,
                            @Param("limit") int limit);
}
