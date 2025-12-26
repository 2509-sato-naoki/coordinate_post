package com.example.coordinate_post.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import com.example.coordinate_post.service.FollowService;

@Controller
public class FollowController {

    @Autowired
    FollowService followService;

    //フォロー追加処理
    @PostMapping("/follow/add")
    @ResponseBody
    public String addFollow(@RequestParam("userId") Integer userId) {
        //各画面にアクセスした際に、ユーザー同士がログインしているかどうかは判断する

        //ログインしているとして、暫定でユーザーID設定
        Integer loginUserId = 53;
        followService.saveFollow(loginUserId, userId);

        return "success";
    }

    //フォロー解除処理
    @PostMapping("/follow/delete")
    @ResponseBody
    public String deleteFollow(@RequestParam("userId") Integer userId) {
        //ログインしているとして、暫定でユーザーID設定
        Integer loginUserId = 53;
        return null;
    }
}
