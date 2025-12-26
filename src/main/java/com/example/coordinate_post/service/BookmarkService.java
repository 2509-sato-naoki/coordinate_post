package com.example.coordinate_post.service;

import com.example.coordinate_post.repository.BookmarkMapper;
import com.example.coordinate_post.repository.entity.Bookmark;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookmarkService {
    @Autowired
    BookmarkMapper bookmarkMapper;

    public Boolean saveBookmark(Integer loginUserId, Integer postId) {
        // 1. すでにブックマークしているか件数を確認する
        int count = bookmarkMapper.countByUserIdAndPostId(loginUserId, postId);

        if (count > 0) {
            // すでに存在する場合は、保存せずに false を返す
            return false;
        } else {
            // 存在しない場合は、保存して true を返す
            bookmarkMapper.saveBookmark(loginUserId, postId);
            return true;
        }
    }

    public void removeBookmark(Integer loginUserId, Integer postId) {
        bookmarkMapper.removeBookmark(loginUserId, postId);
    }

    public Boolean hasBookmarked(Integer loginUserId, Integer postId) {
        Bookmark bookmark = bookmarkMapper.selectBookmark(loginUserId, postId);
        if (bookmark != null) {
            return true;
        } else {
            return false;
        }
    }
}
