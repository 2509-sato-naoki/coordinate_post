package com.example.coordinate_post.controller;

import com.example.coordinate_post.dto.CategoryPostDto;
import com.example.coordinate_post.model.Category;
import org.springframework.beans.factory.annotation.Autowired;
import com.example.coordinate_post.service.PostsService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class HomeController {

    @Autowired
    PostsService postsService;

    @GetMapping("/")
    public ModelAndView homeContent() {
        ModelAndView mav = new ModelAndView();
        mav.setViewName("index");

        //#コートのカテゴリが紐づいている投稿を取得する処理
        Category coat = Category.COAT;
        List<CategoryPostDto> coatPost = postsService.findCategoryPost(coat);

        //#コートのカテゴリが紐づいている投稿を取得する処理
        Category loafers = Category.LOAFERS;
        List<CategoryPostDto> loafersPost = postsService.findCategoryPost(loafers);

        mav.addObject("coatPost", coatPost);
        mav.addObject("loafersPost", loafersPost);
        return mav;
    }
}
