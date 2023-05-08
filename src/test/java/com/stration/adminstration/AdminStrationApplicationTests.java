package com.stration.adminstration;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.stration.adminstration.generator.mapper.UserMapper;
import com.stration.adminstration.generator.pojo.User;
import com.stration.adminstration.generator.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class AdminStrationApplicationTests {

    @Autowired
    private UserService userService;

    @Autowired
    private UserMapper mapper;

    @Test
    void contextLoads() {
        Page<User> page =new Page<>(1,2);
        System.out.println(userService.selectPageVo(page,null));
    }

}
