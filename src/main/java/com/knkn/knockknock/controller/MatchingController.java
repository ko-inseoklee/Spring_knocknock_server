package com.knkn.knockknock.controller;

import com.knkn.knockknock.domain.matching.Matching;
import com.knkn.knockknock.service.MatchingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class MatchingController {
    @Autowired
    private final MatchingService matchingService;

    public MatchingController(MatchingService matchingService) {
        this.matchingService = matchingService;
    }

    @GetMapping("matching/{matching:[0-9]*}")
    @ResponseBody
    public Matching joinMatchingRoom(@PathVariable Long roomID, @RequestParam("user-id") String id){
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
