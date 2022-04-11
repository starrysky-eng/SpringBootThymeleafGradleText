package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.example.demo.dto.UserSearchRequest;
import com.example.demo.entity.User;
import com.example.demo.service.UserService;

import java.util.List;

/**
 * ユーザー情報 Controller
 */
@Controller
public class UserController {
    /**
     * ユーザー情報 Service
     */
    @Autowired
    UserService userService;

    /**
     * ユーザー情報検索画面を表示
     * @param model Model
     * @return ユーザー情報一覧画面
     */
    @GetMapping(value = "/user/search")
    public String displaySearch(Model model) {
        String onClickButton = "FirstClick";
        model.addAttribute("onClickButton",onClickButton);
        return "user/search";
    }

    /**
     * ユーザー情報検索
     * @param userSearchRequest リクエストデータ
     * @param model Model
     * @return ユーザー情報一覧画面
     */
    @RequestMapping(value = "/user/id_search", method = RequestMethod.POST)
    public String search(@ModelAttribute UserSearchRequest userSearchRequest, Model model) {
        User user = userService.search(userSearchRequest);
        System.out.println(userSearchRequest);
        model.addAttribute("userinfo", user);
        return "user/search";
    }
    @RequestMapping(value = "/user/all_search",method = RequestMethod.POST)
    public String searchAll(Model model) {
        List<User> userList = userService.searchAll();
        model.addAttribute("usersinfo",userList);
        return "user/search";
    }
}
