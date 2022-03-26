package com.knkn.knockknock.controller;

import com.knkn.knockknock.domain.matching.Matching;
import com.knkn.knockknock.exceptionHandler.CustomizedResponseEntityExceptionHandler;
import com.knkn.knockknock.service.MatchingService;
import com.knkn.knockknock.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class MatchingController {
    @Autowired
    private final MatchingService matchingService;

    @Autowired
    private final UserService userService;

    @Autowired
    private final CustomizedResponseEntityExceptionHandler exceptionHandler;

    public MatchingController(MatchingService matchingService, UserService userService, CustomizedResponseEntityExceptionHandler exceptionHandler) {
        this.matchingService = matchingService;
        this.userService = userService;
        this.exceptionHandler = exceptionHandler;
    }

    @GetMapping("matching/{matching:[0-9]*}")
    @ResponseBody
    public Matching joinMatchingRoom(@PathVariable Long roomID, @RequestParam("user-id") String id){
//        if(userService.currentUser(id) == null) throw exceptionHandler.handleAllExceptions()
        if(matchingService.joinMatchingRoom(roomID, id)) return matchingService.getMatching(roomID);
        else return null;
    }

    @PostMapping(value = "matching/create")
    public String createMatching(@RequestBody Matching matching){
        try{
            matchingService.createMatchingRoom(matching);
            return "/true";
        } catch (Exception e){
            e.printStackTrace();
            return "/false";
        }

    }
}
