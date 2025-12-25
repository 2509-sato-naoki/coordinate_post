package com.example.coordinate_post.controller;

import com.example.coordinate_post.dto.UserDto;
import com.example.coordinate_post.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping("/users")
    public ModelAndView usersContents() {
        ModelAndView mav = new ModelAndView();
        List<UserDto> users = userService.getUsers(0, 10);
        mav.addObject("users", users);
        mav.setViewName("users");
        return mav;
    }

    // 2. Ajax用：追加のユーザーをJSONで返す
    @GetMapping("/users/api/more")
    @ResponseBody // これをつけるとHTMLではなくJSONデータを返す
    public List<UserDto> loadMore(@RequestParam("offset") int offset) {
        return userService.getUsers(offset, 10);
    }
}
