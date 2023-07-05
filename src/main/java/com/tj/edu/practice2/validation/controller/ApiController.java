package com.tj.edu.practice2.validation.controller;

import com.tj.edu.practice2.validation.model.dto.User;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Size;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api")
@Validated
public class ApiController {

    @GetMapping("/userAll")
    public String user() {
        return null;
    }

    @GetMapping("/user")
    public String user(@Size(min=2) @RequestParam String name, @RequestParam int age) {
        return "이름 : " + name + ", 나이 : " + age;
    }

    @PostMapping("/user")
    //@Valid Request 모델안에 있는 유효성 검사 annotation을 적용하기 위한 annotation
    //@RequestBody : http header안에 있는 content-type의 값을 application/json으로 제한하기 위한 annotation
    //BindingResult : Valid 에러에 걸려도 필터링을 BindingResult에 위임한다
    public ResponseEntity user(@Valid @RequestBody User user, BindingResult bindingResult) {
        System.out.println(user);

        if(bindingResult.hasErrors()) {
            System.out.println("에러코드가 나옴");

            List<ObjectError> listObjectError = bindingResult.getAllErrors();
            for (ObjectError objectError : listObjectError) {
                FieldError fieldError = (FieldError) objectError;

                System.out.println(fieldError.getField());
                System.out.println(fieldError.getDefaultMessage());
            }
        }

        return ResponseEntity.ok(user);
    }
}
