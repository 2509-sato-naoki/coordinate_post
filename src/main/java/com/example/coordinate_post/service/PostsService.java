package com.example.coordinate_post.service;

import com.example.coordinate_post.dto.CategoryPostDto;
import com.example.coordinate_post.dto.PostDetailDto;
import com.example.coordinate_post.dto.PostDto;
import com.example.coordinate_post.model.Category;
import com.example.coordinate_post.repository.CategoryPostMapper;
import com.example.coordinate_post.repository.PostMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostsService {

    @Autowired
    CategoryPostMapper categoryPostMapper;

    @Autowired
    PostMapper postMapper;
    public List<CategoryPostDto> findCategoryPost(Category post) {
        List<CategoryPostDto> categoryPostDto = categoryPostMapper.findCategoryPost(post);
        return categoryPostDto;
    }

    public List<PostDto> findPosts(int offset, int limit) {
        List<PostDto> postDto = postMapper.findPost(offset, limit);
        return postDto;
    }

    public PostDetailDto findById(int postId) {
        return postMapper.findById(postId);
    }
}
