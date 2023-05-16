package com.stration.adminstration.generator.controller;

import com.stration.adminstration.generator.Result.Code;
import com.stration.adminstration.generator.Result.Result;
import com.stration.adminstration.generator.pojo.User;
import com.stration.adminstration.generator.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
public class LoginController {

    @Autowired
    private UserService userService;

    @PostMapping
    public Result userLogin(@RequestBody User user){
        try{
            return new Result(Code.PostSuccess,"登录成功");
        }catch(Exception exception){
            return new Result(Code.PostEro,"登录失败",exception.getMessage());
        }
    }
}
