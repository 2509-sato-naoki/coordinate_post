package com.example.coordinate_post.repository;

import com.example.coordinate_post.dto.PostDetailDto;
import com.example.coordinate_post.dto.PostDto;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface PostMapper {
    List<PostDto> findPost(@Param("offset") int offset,
                           @Param("limit") int limit);

    PostDetailDto findById(@Param("postId") int postId);
}
