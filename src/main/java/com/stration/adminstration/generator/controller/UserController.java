package com.stration.adminstration.generator.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.stration.adminstration.generator.Result.Code;
import com.stration.adminstration.generator.Result.Result;
import com.stration.adminstration.generator.pojo.User;
import com.stration.adminstration.generator.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired UserService userService;

    @GetMapping
    public Result getListUser(@RequestParam Integer pageNumber,@RequestParam Integer pageSize){
        try{
            Page<User> page =new Page<>(pageNumber,pageSize);
            List<User> users = userService.selectPageVo(page, null);
            return new Result(Code.GetSuccess,"查找成功",users,page.getTotal());
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
