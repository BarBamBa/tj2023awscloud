package com.tj.edu.practice;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class MvcController1 {
    //    @RequestMapping("/test1")
    @GetMapping("/test2")
    public String test2() {
        return "test2";

    }
}