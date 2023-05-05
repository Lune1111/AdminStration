package generator.mapper;

import generator.pojo.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
* @author HP
* @description 针对表【sys_user】的数据库操作Mapper
* @createDate 2023-05-05 10:48:25
* @Entity generator.pojo.User
*/
@Repository
public interface UserMapper extends BaseMapper<User> {

}




