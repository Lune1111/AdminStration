package com.stration.adminstration.generator.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.stration.adminstration.generator.mapper.UserMapper;
import com.stration.adminstration.generator.pojo.LoginUser;
import com.stration.adminstration.generator.pojo.User;
import io.netty.handler.codec.bytes.ByteArrayEncoder;
import org.apache.tomcat.util.http.parser.Authorization;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
@Service("UserDetailsService")
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserMapper mapper;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        QueryWrapper queryWrapper =new QueryWrapper();
        queryWrapper.eq("user_name",username);
        User user =mapper.selectOne(queryWrapper);
        if(user==null){
            return null;
        }
        return new LoginUser(user);
    }
}
