package com.devashish.citysocial.one.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController()
public class OneController {
    @GetMapping("/")
    String homePahe(){
        return "this is home";
    }
}
