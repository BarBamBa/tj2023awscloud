package com.tj.edu.practice1;

import org.springframework.web.bind.annotation.*;

@RestController
public class MvcApiController1 {
    @GetMapping(value = "test1")
    public String test1() {
        return "test1 page입니다!";
    }

    //POST 메소드는 데이터를 등록하는 메소드
    @PostMapping(value = "/post-test1")
    public String postTest1() {
        return """
                {
                    "name": "홍길동"
                    "birth": "1990-08-08"
                }
                """;
    }

    //PUT 메소드는 데이터를 업데이트하는 메소드
    @PutMapping(value = "/put-test1")
    public String putTest1() {
        return "Put은 업데이트하는 메소드 ";
    }

    @DeleteMapping(value = "delete-test1")
    public String deleteTest1() {
        return "Delete는 삭제하는 메소드";
    }
}
