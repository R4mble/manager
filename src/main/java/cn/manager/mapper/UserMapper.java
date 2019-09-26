package cn.manager.mapper;

import cn.manager.model.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author Wangyl
 * @date 2019/9/26
 */
public interface UserMapper extends BaseMapper<User> {

    User findByName(String name);

    List<User> findUser(@Param("user") User user);
}
