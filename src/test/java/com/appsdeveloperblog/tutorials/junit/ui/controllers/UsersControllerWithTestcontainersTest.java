package com.appsdeveloperblog.tutorials.junit.ui.controllers;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.testcontainers.containers.MySQLContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;

import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@Testcontainers
public class UsersControllerWithTestcontainersTest {

    @Container
    // static allows up test container for all methods in this class!
    private static MySQLContainer mySQLContainer = new MySQLContainer("mysql:8.0")
            .withDatabaseName("photo_app")
            .withUsername("sergey")
            .withPassword("sergey");

    @DynamicPropertySource // allows dynamically override property source
    private static void overrideProperties(DynamicPropertyRegistry registry){
        registry.add("spring.datasource.url", mySQLContainer::getJdbcUrl);
        registry.add("spring.datasource.username", mySQLContainer::getUsername);
        registry.add("spring.datasource.password", mySQLContainer::getPassword);
    }

    @Test
    @DisplayName("MySql container is created and is running")
    void testContainerIsRunning() {
        assertTrue(mySQLContainer.isCreated(), "MySql container has not been created");
        assertTrue(mySQLContainer.isRunning(), "MySql container is not running");
    }


}