package com.example.coordinate_post.controller;

import com.example.coordinate_post.dto.PostDetailDto;
import com.example.coordinate_post.dto.PostDto;
import com.example.coordinate_post.service.PostsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class PostsController {

    @Autowired
    PostsService postsService;

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
        ModelAndView mav = new ModelAndView();
        mav.setViewName("post");
        PostDetailDto postDetailDto = postsService.findById(postId);
        mav.addObject("postDetailDto", postDetailDto);
        return mav;
    }
}
