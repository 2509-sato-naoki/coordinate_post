package com.example.coordinate_post.repository.entity;

import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;

@Getter
@Setter
public class Bookmark {
    private Integer id;
    private Integer userId;
    private Integer postId;
    private Timestamp createdAt;
    private Timestamp updatedAt;
}
