package com.example.coordinate_post.controller;

import com.example.coordinate_post.dto.PostDetailDto;
import com.example.coordinate_post.dto.PostDto;
import com.example.coordinate_post.service.BookmarkService;
import com.example.coordinate_post.service.PostsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class PostsController {

    @Autowired
    PostsService postsService;

    @Autowired
    BookmarkService bookmarkService;

    @GetMapping("/posts")
    public ModelAndView postsContent() {
        ModelAndView mav = new ModelAndView();
        mav.setViewName("posts");

        //最初の10件の投稿データを取り出す
        List<PostDto> postsDtoList = postsService.findPosts(0,10);
        mav.addObject("postsDtoList", postsDtoList);
        return mav;
    }

    //ajax用
    @GetMapping("/posts/more")
    @ResponseBody
    public List<PostDto> morePosts(@RequestParam("offset") int offset) {
        return postsService.findPosts(offset, 10);
    }

    @GetMapping("/{accountId}/{postId}")
    public ModelAndView postsDetailContents(@PathVariable("accountId") String accountId,
                                            @PathVariable("postId") Integer postId) {
        //ログインしているとして、暫定でユーザーID設定
        Integer loginUserId = 53;
        //ログインしているユーザーのIDをもとに、このpostIdの投稿に既にブックマークしているかどうかを確認する処理
        Boolean hasBookmarked = bookmarkService.hasBookmarked(loginUserId, postId);
        ModelAndView mav = new ModelAndView();
        mav.setViewName("post");
        PostDetailDto postDetailDto = postsService.findById(postId);
        mav.addObject("postDetailDto", postDetailDto);
        mav.addObject("hasBookmarked", hasBookmarked);
        return mav;
    }

    //ajaxでブックマーク追加機能を実装　ブックマークの保存
    @PostMapping("/bookmark/add")
    @ResponseBody
    public String bookmarkAddContents(@RequestParam("postId") Integer postId) {
        //ログインしているとして、暫定でユーザーID設定
        Integer loginUserId = 53;
        Boolean trueOrFalse = bookmarkService.saveBookmark(loginUserId, postId);
        if (trueOrFalse) {
            return "success";
        } else {
            return "false";
        }
    }

    //ajaxでブックマーク解除機能の実装 ブックマークの解除
    @PostMapping("/bookmark/remove")
    @ResponseBody
    public String bookmarkRemoveContents(@RequestParam("postId") Integer postId) {
        //ログインしているとして、暫定でユーザーID設定
        Integer loginUserId = 53;
        //ブックマーク追加処理であったbookmarkテーブルの中を確認する部分は、ページにアクセスするときに確認すればいい
        //Booleanではなくvoidで実装
        bookmarkService.removeBookmark(loginUserId, postId);
        return "success";
    }
}
