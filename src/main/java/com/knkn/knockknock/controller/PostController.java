package com.knkn.knockknock.controller;

import com.knkn.knockknock.domain.TopicOfDay;
import com.knkn.knockknock.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class PostController {
    @Autowired
    private final PostService postService;


    public PostController(PostService postService) {
        this.postService = postService;
    }

    @GetMapping("topic-of-day/{today:[0-9]*}")
    @ResponseBody
    public TopicOfDay getTodayTopic(@PathVariable Long today){
        return postService.getDailyTopic(today);
    }

}
