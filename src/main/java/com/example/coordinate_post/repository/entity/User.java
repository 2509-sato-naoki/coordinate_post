package com.example.coordinate_post.repository.entity;

import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;

@Getter
@Setter
public class User {
    private Integer id;
    private String email;
    private String password;
    private String name;
    private Integer role;
    private Boolean isStopped;
    private String profileImageUrl;
    private Integer sex;
    private String accountId;
    private Timestamp createdAt;
    private Timestamp updatedAt;
}
