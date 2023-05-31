package com.stration.adminstration.generator.controller;

import com.stration.adminstration.generator.Minio.MinioTemplate;
import com.stration.adminstration.generator.Result.Code;
import com.stration.adminstration.generator.Result.Result;
import com.stration.adminstration.generator.pojo.User;
import com.stration.adminstration.generator.service.UserService;
import com.stration.adminstration.generator.util.JWTUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/login")
public class LoginController {

    @Autowired
    private UserService userService;
    @Autowired
    private MinioTemplate minioTemplate;

    @PostMapping
    public Result userLogin(@RequestBody User user) {
        try {
            return new Result(Code.PostSuccess,userService.login(user));

        } catch (Exception exception) {
            return new Result(Code.PostEro, "登录失败", exception.getMessage());
        }
    }

    @PostMapping("/register")
    public Result registerUser(@RequestBody User headImage){
        try{
            String jwt =JWTUtils.geneJsonWebToken(headImage);
            headImage.setPassword(jwt);
            userService.save(headImage);
            return new Result(Code.PostSuccess,"注册成功");
        }catch(Exception exception){
            System.out.println(exception.getMessage());
            return new Result(Code.PostEro,"ERO");
        }
    }
}
