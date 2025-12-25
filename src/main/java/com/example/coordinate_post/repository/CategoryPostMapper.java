package com.example.coordinate_post.repository;

import com.example.coordinate_post.dto.CategoryPostDto;
import com.example.coordinate_post.model.Category;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface CategoryPostMapper {
    List<CategoryPostDto> findCategoryPost(@Param("category") Category category);
}
