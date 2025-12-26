package com.example.coordinate_post.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PostDetailDto {
    //投稿のID
    private Integer id;
    //投稿の画像
    private String postImageUrl;

    //アイテム画像
    private String itemImageUrl;

    //ブランド名
    private String brandName;

    //投稿の説明文
    private String description;

    //ブックマークの数
    private Integer bookmarkCount;

    //プロフィール画像
    private String profileImageUrl;

    //ユーザー名
    private String userName;

    //投稿したユーザーのID
    private Integer userId;
}
