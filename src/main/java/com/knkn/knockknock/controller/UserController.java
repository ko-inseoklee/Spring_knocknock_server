package com.knkn.knockknock.controller;

import com.knkn.knockknock.domain.user.User;
import com.knkn.knockknock.exceptionHandler.UserNotFoundException;
import com.knkn.knockknock.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/users")
public class UserController {

    @Autowired
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    //PRG 패턴
    @PostMapping("create")
    public String createUser(@RequestBody User user){
        boolean result = userService.signUp(user);
        if(result) return "redirect:/true";
        else return "redirect:/false";
    }

    @GetMapping("true")
    @ResponseBody
    public boolean createSuccess(){
        return true;
    }

    @GetMapping("false")
    @ResponseBody
    public boolean createFail(){
        return false;
    }

    @ResponseBody
    public List<User> showAll(){
        return userService.findUsers();
    }

    @GetMapping("verify-id")
    @ResponseBody
    public boolean checkVerifyId(@RequestParam("id") String id){
        return userService.checkDuplicateID(id);
    }

    @GetMapping("verify-nickname")
    @ResponseBody
    public boolean checkVerifyNickname(@RequestParam("nickname") String nickname){
        return userService.checkDuplicateNickName(nickname);
    }

    @GetMapping("{id}")
    @ResponseBody
    public ResponseEntity<User> getUser(@PathVariable String id){
        if(userService.currentUser(id) == null) throw new UserNotFoundException(String.format("%s not found",id));
        User user = userService.currentUser(id);
        return new ResponseEntity<User>(user, HttpStatus.OK);
    }

}
