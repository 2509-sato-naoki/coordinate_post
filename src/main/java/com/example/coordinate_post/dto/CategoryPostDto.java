package com.example.coordinate_post.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CategoryPostDto {
    private Integer id;
    private Integer userId;
    private String accountId;
    private String postImageUrl;
    private String imageUrl;
    private String profileImageUrl;
    private String userName;
}
