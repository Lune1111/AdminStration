package com.stration.adminstration.generator.service.impl;

import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.stration.adminstration.generator.Result.Code;
import com.stration.adminstration.generator.Result.Result;
import com.stration.adminstration.generator.pojo.User;
import com.stration.adminstration.generator.service.UserService;
import com.stration.adminstration.generator.mapper.UserMapper;
import lombok.val;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

/**
 * @author HP
 * @description 针对表【sys_user】的数据库操作Service实现
 * @createDate 2023-05-05 10:48:25
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {
    @Autowired
    private AuthenticationManager authentication;

    @Override
    public List<User> selectPageVo(IPage<User> page, Integer state) {
        return baseMapper.selectPageVo(page, state);
    }

    @Override
    public String login(User user) {
        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(user.getUserName(), user.getPassword());
        Authentication authenticate = authentication.authenticate(authenticationToken);
        if (Objects.isNull(authenticate)) {
            return "用户不存在";
        } else {
            return "登录成功";
        }
    }
}




