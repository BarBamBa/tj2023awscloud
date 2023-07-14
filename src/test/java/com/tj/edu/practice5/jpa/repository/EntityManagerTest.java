package com.tj.edu.practice5.jpa.repository;

import jakarta.persistence.EntityManager;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class EntityManagerTest {
    @Autowired
    private EntityManager em;

    @Test
    void entityManagerTest() {
        em.createQuery("select u from member u").getResultList().forEach(s -> System.out.println(s));
    }
}
