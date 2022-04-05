package com.knkn.knockknock.controller;

import com.knkn.knockknock.ResponseMessage;
import com.knkn.knockknock.StatusCode;
import com.knkn.knockknock.domain.matching.Matching;
import com.knkn.knockknock.exceptionHandler.CustomizedResponseEntityExceptionHandler;
import com.knkn.knockknock.service.MatchingService;
import com.knkn.knockknock.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class MatchingController {
    @Autowired
    private final MatchingService matchingService;

    @Autowired
    private final UserService userService;

    @Autowired
    private final CustomizedResponseEntityExceptionHandler exceptionHandler = new CustomizedResponseEntityExceptionHandler();

    public MatchingController(MatchingService matchingService, UserService userService, CustomizedResponseEntityExceptionHandler exceptionHandler) {
        this.matchingService = matchingService;
        this.userService = userService;
    }

    @GetMapping("matching/{matching:[0-9]*}")
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    public CustomResponseEntity<Matching> joinMatchingRoom(@PathVariable Long roomID, @RequestParam("user-id") String id){
        CustomResponseEntity<Matching> response = null;
        if(matchingService.joinMatchingRoom(roomID, id)) {
            Matching matching =  matchingService.getMatching(roomID);
             response = new CustomResponseEntity<Matching>(StatusCode.OK, ResponseMessage.MATCHING_JOIN_SUCCESS, matching);
            return response;
        }
        // Exception 1. 현재 유저 정보가 없을 경우 2. 이미 참여한 사람이 있을 경우.

        else {
//            throw exceptionHandler.
//                    handleAllExceptions(new RuntimeException(),ResponseMessage.MATCHING_JOIN_FAIL);
        }
        return response;
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
