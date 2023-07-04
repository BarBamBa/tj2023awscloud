package com.tj.edu.practice2.spring_ioc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class SpringIocApplication {
    public static void main(String[] args) {
        SpringApplication.run(SpringIocApplication.class, args);
        ApplicationContext applicationContext = ApplicationContextProvider.getApplicationContext();

        applicationContext.getBean(null);
        System.out.println("hi");
    }
}
