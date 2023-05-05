package generator.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import generator.pojo.User;
import generator.service.UserService;
import generator.mapper.UserMapper;
import org.springframework.stereotype.Service;

/**
* @author HP
* @description 针对表【sys_user】的数据库操作Service实现
* @createDate 2023-05-05 10:48:25
*/
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService{

}




