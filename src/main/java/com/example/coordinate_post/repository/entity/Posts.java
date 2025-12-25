package com.example.coordinate_post.repository.entity;

import java.sql.Timestamp;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Posts {
    private Integer id;
    private Integer user_id;
    private String postsImageUrl;
    private String description;
    private Timestamp createdAt;
    private Timestamp updatedAt;
}
