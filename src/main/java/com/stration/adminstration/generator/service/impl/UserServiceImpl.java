package com.stration.adminstration.generator.service.impl;

import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.stration.adminstration.generator.pojo.User;
import com.stration.adminstration.generator.service.UserService;
import com.stration.adminstration.generator.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
* @author HP
* @description 针对表【sys_user】的数据库操作Service实现
* @createDate 2023-05-05 10:48:25
*/
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService{
    @Override
    public List<User> selectPageVo(IPage<User> page, Integer state) {
        return baseMapper.selectPageVo(page,state);
    }

    @Override
    public boolean login(User user) {
        QueryWrapper queryWrapper =new QueryWrapper();
        String Name=user.getUserName();
        String Password=user.getPassword();
        if(StrUtil.isBlank(Name)  || StrUtil.isBlank(Password)){
            queryWrapper.eq("user_name",Name);
            queryWrapper.eq("password",Password);
            try{
                baseMapper.selectOne(queryWrapper);
                return true;
            }catch (Exception exception){
                exception.getMessage();
                return false;
            }
        }else {
            return false;
        }
    }
}




