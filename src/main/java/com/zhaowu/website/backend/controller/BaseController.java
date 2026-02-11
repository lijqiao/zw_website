package com.zhaowu.website.backend.controller;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/base")
public class BaseController {

    @Value("${value}")
    private String value;

    @GetMapping("/test")
    public void test(){
        System.out.println(value);
    }
}
