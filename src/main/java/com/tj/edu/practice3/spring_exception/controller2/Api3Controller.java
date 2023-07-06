package com.tj.edu.practice3.spring_exception.controller2;


import com.tj.edu.practice3.spring_exception.dto.User;
import jakarta.validation.constraints.Size;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api3")
@Validated
public class Api3Controller {

    @GetMapping("/user")
    public User user(
            @Size(min=2) @RequestParam String name,
            @RequestParam int age) {

        User user = new User();
        user.setName(name);
        user.setAge(age);

        return user;
    }
}
