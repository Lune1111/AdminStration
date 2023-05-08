package com.stration.adminstration.generator.mapper;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.stration.adminstration.generator.pojo.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import io.lettuce.core.dynamic.annotation.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
* @author HP
* @description 针对表【sys_user】的数据库操作Mapper
* @createDate 2023-05-05 10:48:25
* @Entity generator.pojo.User
*/
@Repository
public interface UserMapper extends BaseMapper<User> {

    List<User> selectPageVo(IPage<User> page, Integer state);
}




