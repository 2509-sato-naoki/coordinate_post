package com.example.coordinate_post.controller;

import com.example.coordinate_post.repository.entity.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {

    @GetMapping("/")
    public ModelAndView homeContent() {
        ModelAndView mav = new ModelAndView();
        mav.setViewName("index");

        //ログイン関係は最後にやるので、一旦仮にユーザーを置く
        
        return mav;
    }
}
