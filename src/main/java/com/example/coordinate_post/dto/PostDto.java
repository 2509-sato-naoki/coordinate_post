package com.example.coordinate_post.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PostDto {

    //投稿のID
    private Integer id;

    //投稿の画像
    private String postImageUrl;

    //ユーザーの名前
    private String userName;

    //ユーザーの画像
    private String profileImageUrl;

    //ユーザーのアカウントID
    private String accountId;

    //性別
    private Integer sex;
}
