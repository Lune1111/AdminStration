package com.stration.adminstration.generator.controller;

import com.stration.adminstration.generator.Result.Code;
import com.stration.adminstration.generator.Result.Result;
import com.stration.adminstration.generator.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired UserService userService;

    @GetMapping
    public Result getListUser(){
        try{
            return new Result(Code.GetSuccess,"查找成功",userService.list());
        }catch(Exception exception){
            return new Result(Code.GetEro,"查找失败");
        }
    }
}
