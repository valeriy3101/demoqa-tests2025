package com.github;

import org.junit.jupiter.api.*;

public class DemoQATest2025 {

    @BeforeAll
    static void beforeAll(){
        System.out.println("Before all tests!\n");
    }

    @AfterAll
    static void afterAll(){
        System.out.println("After all tests!\n");
    }


    @BeforeEach
    void beforeEach(){
        System.out.println("Before Test!\n");
    }

    @AfterEach
    void afterEach(){
        System.out.println("After test!\n");
    }

    @Test
    void firstTest() {
        System.out.println("I love you QA.GURU\n");
    }

    @Test
    void secondTest() {
        System.out.println("I love you Sasha\n");
        
    }

}
