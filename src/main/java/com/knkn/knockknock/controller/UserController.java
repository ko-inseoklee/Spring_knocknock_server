package com.knkn.knockknock.controller;

import com.knkn.knockknock.ResponseMessage;
import com.knkn.knockknock.StatusCode;
import com.knkn.knockknock.domain.user.User;
import com.knkn.knockknock.exceptionHandler.UserNotFoundException;
import com.knkn.knockknock.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
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
    @ResponseStatus(HttpStatus.CREATED)
    public CustomResponseEntity<Boolean> createSuccess(){
        return new CustomResponseEntity<Boolean>(StatusCode.CREATED, ResponseMessage.USER_CREATE_SUCCESS,true);
    }

    @GetMapping("false")
    @ResponseBody
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public CustomResponseEntity<Boolean> createFail(){
        return new CustomResponseEntity<Boolean>(StatusCode.BAD_REQUEST, ResponseMessage.USER_CREATE_FAIL,false);
    }
    @ResponseBody
    public List<User> showAll(){
        return userService.findUsers();
    }


    //TODO: ID에 입력할 수 없는 단어가 오면 변경해줘야 함.
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
    @ResponseStatus(HttpStatus.OK)
    public CustomResponseEntity<User> getUser(@PathVariable String id){
        if(userService.currentUser(id) == null) throw new UserNotFoundException(String.format("%s not found",id));
        HttpHeaders headers = new HttpHeaders();
        User user = userService.currentUser(id);
        ResponseEntity entity = ResponseEntity.ok(user);
        CustomResponseEntity customResponseEntity = new CustomResponseEntity(StatusCode.OK, ResponseMessage.USER_FOUND,user);
        return customResponseEntity;
    }
}
