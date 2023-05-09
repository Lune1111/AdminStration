package com.stration.adminstration.generator.controller;

import cn.hutool.http.server.HttpServerRequest;
import cn.hutool.http.server.HttpServerResponse;
import cn.hutool.json.JSONArray;
import cn.hutool.poi.excel.ExcelReader;
import cn.hutool.poi.excel.ExcelUtil;
import cn.hutool.poi.excel.ExcelWriter;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.stration.adminstration.generator.Result.Code;
import com.stration.adminstration.generator.Result.Result;
import com.stration.adminstration.generator.pojo.User;
import com.stration.adminstration.generator.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.InputStream;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    UserService userService;

    @GetMapping
    public Result getListUser(@RequestParam Integer pageNumber, @RequestParam Integer pageSize) {
        try {
            Page<User> page = new Page<>(pageNumber, pageSize);
            List<User> users = userService.selectPageVo(page, null);
            return new Result(Code.GetSuccess, "查找成功", users, page.getTotal());
        } catch (Exception exception) {
            return new Result(Code.GetEro, "查找失败");
        }
    }

    @PostMapping
    public Result InsertNewUser(@RequestBody User user) {
        try {
            return new Result(Code.PostSuccess, "添加成功", userService.save(user));
        } catch (Exception exception) {
            return new Result(Code.PostEro, "添加失败");
        }
    }

    @PutMapping
    public Result updateUser(@RequestBody User user) {
        try {
            return new Result(Code.PutSuccess, "修改成功", userService.updateById(user));
        } catch (Exception exception) {
            System.out.println(exception.getMessage());
            return new Result(Code.PostEro, "修改失败");
        }
    }

    @PostMapping("/deleteIds")
    public Result deleteUser(@RequestBody List<Integer> ids) {
        try {
            System.out.println(ids);
            return new Result(Code.DeleteSuccess, "删除成功", userService.removeByIds(ids));
        } catch (Exception exception) {
            System.out.println(exception.getMessage());
            return new Result(Code.DeleteEro, "删除失败");
        }
    }

    @GetMapping("/outUser")
    public Result outUserMsg(HttpServletResponse response) {
        try {
            List<User> users = userService.list();
            ExcelWriter writer = ExcelUtil.getWriter(true);
            //自定义标题别名
            writer.addHeaderAlias("userName", "账户名");
            writer.addHeaderAlias("nickName", "昵称");
            writer.addHeaderAlias("phonenumber", "手机号");
            writer.addHeaderAlias("email", "邮箱");

            response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet;charset=utf-8");
            String fileName = URLEncoder.encode("用户信息", "UTF-8");
            response.setHeader("Content-Disposition", "attachment;filename=" + fileName + ".xlsx");
            // 一次性写出内容，使用默认样式，强制输出标题
            writer.write(users, true);
            ServletOutputStream out = response.getOutputStream();
            writer.flush(out, true);
            out.close();
//            关闭writer
            writer.close();
            return new Result(Code.GetSuccess, "导入成功");
        } catch (Exception exception) {
            return new Result(Code.GetEro, "导入失败");
        }
    }

    @PostMapping("/importUser")
    public Result imUser(MultipartFile file) {
        try {
            InputStream inputStream =file.getInputStream();
            ExcelReader reader =ExcelUtil.getReader(inputStream);
            List<User> users =reader.readAll(User.class);
            System.out.println(users);
        } catch (Exception exception) {

        }
        return null;
    }
}
