package com.tj.edu.practice4.interceptor_filter.controller;

import com.tj.edu.practice4.interceptor_filter.dto.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api")
public class RestApiController {


    @GetMapping("/user/{id}")
    public String user(@PathVariable(name = "id") String id1, @RequestParam(required = false, defaultValue = "김복순") String name) {
//    public String user(@PathVariable String id1, @RequestParam String name) {  오류남 url parameter와 PathVariable 변수명이 같아야 함

        System.out.println("id : " + id1);
        System.out.println("name : " + name);
        
        return id1 + " " + name;
    }

    @PostMapping("/user")
    public ResponseEntity user(@RequestBody User user) {

        System.out.println("id : " + user.getId());
        System.out.println("name : " + user.getName());

        return ResponseEntity.ok(user);
    }

    @PutMapping("/user")
    public User updateUser(User user) {

        user.setId("NewId");
        user.setName("NewName");
        user.setPw("NewPw");

        return user;
    }

}


