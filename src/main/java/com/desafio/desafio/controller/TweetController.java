package com.desafio.desafio.controller;

import com.desafio.desafio.service.TweetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@Controller
@CrossOrigin
@RequestMapping("tweets")
public class TweetController {

    @Autowired
    private TweetService tweetService;

    @GetMapping
    public ResponseEntity getTweetByFilter() {
        return tweetService.getTweetByFilter();
    }

    @PostMapping
    public ResponseEntity insertTweets(@RequestParam MultipartFile file) {
        return tweetService.insertTweets(file);
    }

}
