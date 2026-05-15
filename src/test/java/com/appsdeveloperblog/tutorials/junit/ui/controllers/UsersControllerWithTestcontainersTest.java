package com.appsdeveloperblog.tutorials.junit.ui.controllers;

import org.springframework.boot.test.context.SpringBootTest;
import org.testcontainers.containers.MySQLContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@Testcontainers
public class UsersControllerWithTestcontainersTest {

    @Container
    // static allows up test container for all methods in this class!
    private static MySQLContainer mySQLContainer = new MySQLContainer("mysql:9.7");


}