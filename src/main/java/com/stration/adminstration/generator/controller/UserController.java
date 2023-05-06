package com.stration.adminstration.generator.controller;

import com.stration.adminstration.generator.Result.Code;
import com.stration.adminstration.generator.Result.Result;
import com.stration.adminstration.generator.pojo.User;
import com.stration.adminstration.generator.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
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

    @PostMapping
    public Result InsertNewUser(@RequestBody User user){
        try{
            return new Result(Code.PostSuccess,"添加成功",userService.save(user));
        }catch(Exception exception){
            return new Result(Code.PostEro,"添加失败");
        }
    }

    @PutMapping
    public Result updateUser(@RequestBody User user){
        try{
            return new Result(Code.PutSuccess,"修改成功",userService.updateById(user));
        }catch(Exception exception){
            System.out.println(exception.getMessage());
            return new Result(Code.PostEro,"修改失败");
        }
    }
}
