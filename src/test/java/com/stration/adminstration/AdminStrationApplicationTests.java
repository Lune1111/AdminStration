package com.stration.adminstration;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.stration.adminstration.generator.mapper.UserMapper;
import com.stration.adminstration.generator.pojo.User;
import com.stration.adminstration.generator.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

@SpringBootTest
class AdminStrationApplicationTests {

    @Autowired
    private UserService userService;

    @Autowired
    private UserMapper mapper;

    @Test
    void contextLoads() {
        int x = 123;
        int z = x;
        int y = 0;
        int c=0;
        while (x != 0) {
            y += x % 10;
            x /= 10;
            if(x/10!=0){
                c=y;
            }
            if (x != 0) {
                y *= 10;
            }
            if (y * 100 == y || y > (int) Math.pow(10, 8) || y < (int) Math.pow(-2, 31))
                System.out.println(0);
            if(c*10>y && y>(int) Math.pow(10, 6))
                System.out.println(0+55);
        }
        System.out.println(y);
    }

}
