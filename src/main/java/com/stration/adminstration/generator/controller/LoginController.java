package com.stration.adminstration.generator.controller;

import com.stration.adminstration.generator.Minio.MinioTemplate;
import com.stration.adminstration.generator.Result.Code;
import com.stration.adminstration.generator.Result.Result;
import com.stration.adminstration.generator.pojo.User;
import com.stration.adminstration.generator.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
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
            System.out.println(user);
            if (userService.login(user)) {
                return new Result(Code.PostSuccess, "登录成功");
            }else{
                return new Result(Code.PostEro,"账号或密码有误！","登陆失败");
            }
        } catch (Exception exception) {
            return new Result(Code.PostEro, "登录失败", exception.getMessage());
        }
    }

    @PostMapping("/register")
    public Result registerUser(@RequestBody User headImage){
        try{
//            List<String> fileList=new ArrayList<>();
//            Long Id = headImage.getUserId();
//            fileList.add(headImage.getAvatar());
//            Map<String,String> map=minioTemplate.uploadBlobTest(fileList,headImage.getUserId(),"avatar");
//            headImage.setAvatar(map.get("url"));
//            headImage.setUserId(Id);
            return new Result(Code.PostSuccess,"注册成功", userService.save(headImage));
        }catch(Exception exception){
            System.out.println(exception.getMessage());
            return new Result(Code.PostEro,"ERO");
        }
    }
}
