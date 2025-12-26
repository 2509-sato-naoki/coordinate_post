package com.example.coordinate_post.repository;

import com.example.coordinate_post.repository.entity.Bookmark;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface BookmarkMapper {
    void saveBookmark(@Param("loginUserId") int loginUserId,
                      @Param("postId") int postId);

    int countByUserIdAndPostId(@Param("userId") Integer userId, @Param("postId") Integer postId);

    void removeBookmark(@Param("loginUserId") int loginUserId,
                        @Param("postId") int postId);

    Bookmark selectBookmark(@Param("loginUserId") int loginUserId,
                            @Param("postId") int postId);
}
