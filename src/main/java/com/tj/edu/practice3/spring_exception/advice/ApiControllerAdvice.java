package com.tj.edu.practice3.spring_exception.advice;

import com.tj.edu.practice3.spring_exception.controller.Api2Controller;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice(
        basePackages = "com.tj.edu.practice3.spring_exception.controller"
        //,basePackageClasses = Api2Controller.class
        )
public class ApiControllerAdvice {

    @ExceptionHandler(value = Exception.class)
    public ResponseEntity exception(Exception e) {
        System.out.println(e.getClass().getName());
        System.out.println("----------------------------");
        System.out.println(e.getLocalizedMessage());

        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("sdafads");
    }

    @ExceptionHandler(value = ArithmeticException.class)
    public ResponseEntity arthmeticsException(ArithmeticException ae) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("0을 나누는 시도를 하였습니다.");
    }

    @ExceptionHandler(value = NullPointerException.class)
    public ResponseEntity nullPointerException(NullPointerException npe) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("내부에서 객체를 생성하지 않아서 오류가 남");
    }
}
