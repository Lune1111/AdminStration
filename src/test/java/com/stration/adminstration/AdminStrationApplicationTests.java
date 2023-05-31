package com.stration.adminstration;

import com.stration.adminstration.generator.service.UserService;
import com.stration.adminstration.generator.service.impl.UserDetailsServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
class AdminStrationApplicationTests {

    @Autowired
    private UserService userService;

    @Autowired
    private UserDetailsServiceImpl service;

    @Test
    void contextLoads() {
        System.out.println(service.loadUserByUsername("张三"));
    }
}
