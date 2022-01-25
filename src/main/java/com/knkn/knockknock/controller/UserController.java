package com.knkn.knockknock.controller;

import com.knkn.knockknock.domain.User;
import com.knkn.knockknock.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
public class UserController {

    @Autowired
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    //PRG 패턴
    @PostMapping("users/create")
    public String createUser(@RequestBody User user){
        boolean result = userService.signUp(user);
        if(result) return "redirect:/users/true";
        else return "redirect:/users/false";
    }

    @GetMapping("users/true")
    @ResponseBody
    public boolean createSuccess(){
        return true;
    }

    @GetMapping("users/true")
    @ResponseBody
    public boolean createFail(){
        return false;
    }

    @GetMapping("users")
    @ResponseBody
    public List<User> showAll(){
        return userService.findUsers();
    }

    @GetMapping("users/verify-id")
    @ResponseBody
    public boolean checkVerifyId(@RequestParam("id") String id){
        return userService.checkDuplicateID(id);
    }

    @GetMapping("users/verify-nickname")
    @ResponseBody
    public boolean checkVerifyNickname(@RequestParam("nickname") String nickname){
        return userService.checkDuplicateNickName(nickname);
    }

}
