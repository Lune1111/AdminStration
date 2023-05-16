package com.stration.adminstration.generator.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.stration.adminstration.generator.pojo.User;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
* @author HP
* @description 针对表【sys_user】的数据库操作Service
* @createDate 2023-05-05 10:48:25
*/

public interface UserService extends IService<User> {

 List<User> selectPageVo(IPage<User> page, Integer state);
boolean login(User user);

}
